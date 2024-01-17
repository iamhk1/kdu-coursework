package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.alldata.AllData;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.trader.Traders;
import org.example.transaction.Transactions;


import java.io.*;
import Logs.Log;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Main{
    public static ArrayList<String[]> parseCSV(Path path) {
        ArrayList<String[]> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toString()))) {
            String readLine;
            int count=0;
            while ((readLine = reader.readLine()) != null) {
                ++count;
                if(count==1)
                    continue;
                String[] values = readLine.split(",");
                processCSVRow(values);
                data.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    private static void processCSVRow(String[] values) {
        if (values.length == 6) {
            processCoinData(values);
        } else if (values.length == 5) {
            processTraderData(values);
        }
    }

    private static void processCoinData(String[] values) {

        AllData.getCoinData().add(values);

    }

    private static void processTraderData(String[] values) {
        Traders newObj = new Traders(values[1], values[2], values[3], values[4]);
         AllData.getProfitLoss().put(values[4], 0.0);
         AllData.getTraderObj().add(newObj);
        AllData.getTraderData().add(values);
    }
    public static JsonNode parseJsonFile(String path) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            File file = new File(path);
            JsonNode jsonNode = objectMapper.readTree(file);

            if (jsonNode != null && jsonNode.isArray()) {

                return jsonNode;
            } else {
                Log.info("JSON node is null or not an array");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void executeTransactions(JsonNode jsonTransactions, CountDownLatch latch) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Check if the JSON array is not null and has elements
            if (jsonTransactions != null && jsonTransactions.isArray() && jsonTransactions.size() > 0) {
                Transactions[] dataList = objectMapper.treeToValue(jsonTransactions, Transactions[].class);

                if (dataList != null) {
                    for (Transactions transaction : dataList) {
                        executorService.submit(() -> {

                            new ExecuteTransaction(transaction, latch);
                            latch.countDown();
                        });
                    }
                } else {
                    Log.info("Data list is null");
                }
            } else {
                Log.info("JSON array is null or empty");
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

}
