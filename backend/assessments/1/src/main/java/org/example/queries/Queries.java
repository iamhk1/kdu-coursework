package org.example.queries;

import org.example.alldata.AllData;
import org.example.player.Player;
import org.example.logger.Log;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Queries {
    public static void greaterThanFortyWickets(String team)
    {
        List<Player> p= AllData.getPlayerList();

        p.stream().filter(e->e.getPlayerTeam().equals(team)&&e.getPlayerWickets()>40).forEach(e->Log.info("Name "+e.getPlayerName()+"Team "+" "+e.getPlayerTeam()+"Wickets "+e.getPlayerWickets()));



    }
    public static  void highestRunsAndWickets(String team)
    {
        List<Player> p= AllData.getPlayerList();
        int runs=-1,wickets=-1;
        String highestRuns="";
        String highestWickets="";
        for(int i=0;i<p.size();i++)
        {
            if(p.get(i).getPlayerTeam().equals(team))
            {
                if(p.get(i).getPlayerWickets()>wickets)
                {
                    wickets=p.get(i).getPlayerWickets();
                    highestWickets=p.get(i).getPlayerName();
                }
                if(p.get(i).getPlayerRuns()>runs)
                {
                    runs=p.get(i).getPlayerRuns();
                    highestRuns=p.get(i).getPlayerName();
                }
            }

        }
        if(wickets==-1&&runs==-1)
        {
            Log.error("Team Not Found");
        }
        if(wickets!=-1)
        {
            Log.info("Highest wickets Taken Are "+wickets+ " Taken by "+highestWickets);
        }
        if(runs!=-1)
        {
            Log.info("Highest Runs  is"+runs+ "  By "+highestRuns);
        }

    }
    public static void findTopThreeWicketTakers()
    {
        List<Player> list= AllData.getPlayerList();
        List<Player> sortedList = list.stream()
                .sorted(Comparator.comparingInt(Player::getPlayerWickets))
                .collect(Collectors.toList());
        for(int i=0;i<50;i++)
        {
            Log.info(sortedList.get(i).getPlayerWickets()+"-wickets "+" name"+sortedList.get(i).getPlayerName());
        }
    }
    public static void findTopThreeHighestScorer()
    {
        List<Player> list= AllData.getPlayerList();
        List<Player> sortedList = list.stream()
                .sorted(Comparator.comparingInt(Player::getPlayerRuns))
                .collect(Collectors.toList());
        for(int i=0;i<3;i++)
        {
            Log.info(sortedList.get(i).getPlayerWickets()+"-Runs "+" name -"+sortedList.get(i).getPlayerName());
        }
    }
}
