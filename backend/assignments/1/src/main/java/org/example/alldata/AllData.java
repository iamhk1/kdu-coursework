package org.example.alldata;

import org.example.coin.Coins;
import org.example.trader.Traders;

import java.math.BigDecimal;
import java.util.*;

public class AllData {
    /**
     * Default constructor.
     *
     * Currently, this constructor does not perform any initialization.
     * It's provided for explicit declaration and may be expanded in the future.
     * If this class is not intended to be instantiated or if instantiation
     * requires specific setup, consider throwing an UnsupportedOperationException.
     */
     public AllData()
    {
        /**
         * Default constructor.
         *
         * Currently, this constructor does not perform any initialization.
         * It's provided for explicit declaration and may be expanded in the future.
         * If this class is not intended to be instantiated or if instantiation
         * requires specific setup, consider throwing an UnsupportedOperationException.
         */
    }
    private static ArrayList<String[]> coinData = new ArrayList<>();
    private static ArrayList<Coins> coinObj = new ArrayList<>();
    private static ArrayList<String[]> traderData = new ArrayList<>();
    private static ArrayList<Traders> traderObj = new ArrayList<>();

    private static HashMap<String, Double> profitLoss = new HashMap<>();

    public static Map<String, Double> getProfitLoss() {
        return profitLoss;
    }

    private static TreeMap<BigDecimal, String> topCoins = new TreeMap<>(Collections.reverseOrder());

    public static TreeMap<BigDecimal, String> getTopCoins() {
        return topCoins;
    }

    public static List<String[]> getCoinData() {
        return coinData;
    }

    public static List<String[]> getTraderData() {
        return traderData;
    }

    public static List<Coins> getCoinObj() {
        return coinObj;
    }

    public static List<Traders> getTraderObj() {
        return traderObj;
    }
}
