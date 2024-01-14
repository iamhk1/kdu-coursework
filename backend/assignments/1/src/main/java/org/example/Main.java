package org.example;

import org.example.alldata.AllData;
import org.example.coin.Coins;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.trader.Traders;
import org.example.transaction.Transactions;


import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    static final AllData obj=new AllData();
    static Transactions[]customobj;
    static JsonNode jsonNode;

public static ArrayList<String[]> parseCSV(Path path) throws IOException {
    try (BufferedReader br = new BufferedReader(new FileReader(path.toString()))) {
        ArrayList<String[]> data = new ArrayList<>();

        String line;
        br.readLine();
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            if(values.length==6)
            {
                String []eachCoin = new String[5];

                for (int i=1;i<values.length;i++) {
                    eachCoin[i-1] = values[i];
                }
                AllData.getCoinData().add(eachCoin);
                Coins newObj = new Coins(Integer.parseInt(values[1]), values[2], values[3], Double.parseDouble(values[4]), Long.parseLong(values[5]));
                AllData.getTopCoins().put(BigDecimal.valueOf(Double.parseDouble(values[4])),values[3]);
                AllData.getCoinObj().add(newObj);
            }
            else
            {
                String []eachTrader = new String[4];

                for(int i=1;i<values.length;i++)
                {
                    eachTrader[i-1]=values[i];
                }

                AllData.getProfitLoss().put(values[4],0.0);
                AllData.getTraderData().add(eachTrader);

                Traders newObj = new Traders(values[1],values[2],values[3],values[4]);
                AllData.getTraderObj().add(newObj);

            }
            data.add(values);
            return data;
        }

    } catch (IOException I) {
        System.out.println(I);
    }

    return new ArrayList<>();
}
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cd=new CountDownLatch(3);
        executeTransactions(jsonNode,cd);

    }
    public static JsonNode parseJsonFile(String path)
    {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            File file = new File(path);

            JsonNode jsonNode=objectMapper.readTree(file);
            customobj=objectMapper.treeToValue(jsonNode,Transactions[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonNode;
    }
    public static void executeTransactions(JsonNode jsonTransactions, CountDownLatch
            latch) throws InterruptedException {
        ExecutorService exs= Executors.newFixedThreadPool(10);
        for(Transactions transactions:customobj)
        {
            exs.submit(new ExecuteTransaction(transactions,latch));
        }
        latch.await();
        exs.shutdown();

    }

}
