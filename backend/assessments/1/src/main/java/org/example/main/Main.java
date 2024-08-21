package org.example.main;


import org.example.alldata.AllData;
import org.example.logger.Log;
import org.example.player.Player;
import org.example.stats.Stats;
import org.example.queries.Queries;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        parseCSV();
        Queries.greaterThanFortyWickets("CSK");
        Queries.highestRunsAndWickets("KKR");
        fnChoice();

    }
    public static void fnChoice()
    {
        Scanner sc=new Scanner(System.in);
        while(true) {
            Log.info("Enter 0 to exit, Enter 1 to see players>40 wickets , Enter 2 to get highest runs and wickets , Enter 3 to get highest 3 wicket takers ,Enter 4 to get 3 highest runs ");
            int n = sc.nextInt();
            if(n==0)
                break;
            else if(n==1)
            {
                Queries.greaterThanFortyWickets("CSK");
            }
            else if(n==2)
            {
                Queries.highestRunsAndWickets("KKR");
            }
            else if(n==3)
            {
                Queries.findTopThreeWicketTakers();
            }
            else if(n==4)
            {
                Queries.findTopThreeHighestScorer();
            }
            else {
                break;
            }
        }

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

