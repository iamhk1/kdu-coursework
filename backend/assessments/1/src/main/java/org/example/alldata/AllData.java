package org.example.alldata;

import org.example.player.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AllData {
    private static List<Player> playerDetails=new ArrayList<>();

    public static List<Player> getPlayerList()
    {
        return playerDetails;

    }
    public static void addPlayer(Player newPlayer)
    {
        playerDetails.add(newPlayer);
    }
}
