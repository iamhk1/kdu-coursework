package org.example.details;
import org.example.alldata.AllData;
import org.example.trader.Traders;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.logging.Logger;

public class ShowDetails {
    static AllData ob = new AllData();
    private static final Logger Log = Logger.getLogger(ShowDetails.class.getName());

    public static void topCoins() {
        Map<BigDecimal, String> treeMap = ob.getTopCoins();
        treeMap.entrySet().stream()
                .limit(5)
                .forEach(entry -> Log.info(entry.getKey() + " => " + entry.getValue()));
    }

    public static void bottomCoins() {
        Log.info("5 Lowest Priced Coins are: ");
        TreeMap<BigDecimal, String> treeMap = ob.getTopCoins();
        Log.info("5 Lowest Priced Coins are: ");

        treeMap.descendingMap()
                .entrySet()
                .stream()
                .limit(5)
                .forEach(entry -> Log.info("Key: " + entry.getKey() + ", Value: " + entry.getValue()));
    }

    public static void topFiveTrader() {
        Map<String, Double> profitLoss = AllData.getProfitLoss();
        List<Map.Entry<String, Double>> topTraders = profitLoss.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(5)
                .collect(Collectors.toList());
        topTraders.forEach(entry -> Log.info("Trader: " + entry.getKey() + ", Profit/Loss: " + entry.getValue()));
    }

    public static void bottomFiveTraders() {
        Map<String, Double> profitLoss = AllData.getProfitLoss();
        List<Map.Entry<String, Double>> bottomTraders = profitLoss.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(5)
                .collect(Collectors.toList());
        bottomTraders.forEach(entry -> Log.info("Trader: " + entry.getKey() + ", Profit/Loss: " + entry.getValue()));
    }

    public static void showPortfolio(String walletId) {
        List<Traders> allTraders = ob.getTraderObj();
        Traders reqTrader = null;
        for (Traders cur : allTraders) {
            if (cur.getWalletAddress().equals(walletId)) {
                reqTrader = cur;
                break;
            }
        }
        if (reqTrader == null) {
            Log.info("Wallet Address Not Found");
            return;
        }
        HashMap<String, Long> portfolio = reqTrader.getPortfolio();
        Log.info("Portfolio");
        for (String coin : portfolio.keySet()) {
            Log.info("Coin: " + coin + " Quantity: " + portfolio.get(coin));
        }
    }

    public static void showPnL(String walletId) {
        if (!ob.getProfitLoss().containsKey(walletId)) {
            Log.info("Wrong wallet id entered");
        } else {
            Log.info("PnL of the given user is " + ob.getProfitLoss().get(walletId));
        }
    }
}
