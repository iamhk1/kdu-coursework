package org.example.main;


import org.example.alldata.AllData;
import org.example.player.Player;
import org.example.stats.Stats;
import org.example.queries.Queries;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        parseCSV();
        Queries.greaterThanFortyWickets("CSK");
        Queries.highestRunsAndWickets("KKR");

    }

    public static void parseCSV() {
        ArrayList<String[]> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/IPL_2021-data.csv"))) {
            String readLine;
            int count = 0;
            while ((readLine = reader.readLine()) != null) {
                ++count;
                if (count == 1)
                    continue;
                String[] values = readLine.split(",");
                processCSVRow(values);


            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static void processCSVRow(String[]values)
    {
        String name=values[0];
        String team=values[1];
        String role=values[2];
        Stats addStats=new Stats(Integer.parseInt(values[3]),Integer.parseInt(values[4]),Double.parseDouble(values[5]),Double.parseDouble(values[6]),Integer.parseInt(values[7]));
        Player addPlayer=new Player(name,role,team,addStats);
        AllData.addPlayer(addPlayer);
    }
}

