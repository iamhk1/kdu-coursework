package org.example.player;


import org.example.stats.Stats;

public class Player implements Comparable<Player>{

    private String playerName;
    private String playerTeam;
    private String playerRole;
    private Stats playerStats;
    public Player()
    {

    }
    public Player(String name,String role,String team,Stats playerStats)
    {
        this.playerRole=role;
        this.playerName=name;
        this.playerTeam=team;
        this.playerStats=playerStats;
    }
    public int compareTo(Player o)
    {
        return o.getPlayerWickets()-this.getPlayerWickets();
    }
    public String getPlayerName()
    {
        return playerName;

    }
    public String getPlayerRole(){
        return playerRole;
    }
    public String getPlayerTeam(){
        return playerTeam;
    }
    public int getPlayerWickets()
    {
        return playerStats.getWickets();
    }
    public int getPlayerRuns()
    {
        return playerStats.getRuns();
    }
}
