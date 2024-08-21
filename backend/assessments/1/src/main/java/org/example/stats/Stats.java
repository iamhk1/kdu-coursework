package org.example.stats;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class Stats {

    private int matches;
    private int runs;
    private double strikeRate;
    private double average;
    private int wickets;
    public Stats(int matches,int runs,double average,double strikeRate,int wickets)
    {
        this.matches=matches;
        this.runs=runs;
        this.strikeRate=strikeRate;
        this.average=average;
        this.wickets=wickets;
    }
    public int getMatches()
    {
        return matches;
    }
    public int getRuns()
    {
        return runs;
    }
    public double getStrikeRate()
    {
        return strikeRate;
    }
    public double getAverage()
    {
        return average;
    }
    public int getWickets()
    {
        return wickets;
    }


}

