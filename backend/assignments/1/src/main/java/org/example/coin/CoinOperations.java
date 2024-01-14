package org.example.coin;

import org.example.alldata.AllData;
import java.math.BigDecimal;
import java.util.List;


import org.example.trader.Traders;

public class CoinOperations {
    CoinOperations()
    {

    }


    public static void buyCoins(Coins obj, String walletAddress, String symbol, long quantity, double price) {
        List<Coins> coinList = AllData.getCoinObj();


        for (int i = 0; i < coinList.size(); i++) {
            if (coinList.get(i).getSymbol().equals(symbol)) {
                long availableCoins = coinList.get(i).getCurrentSupply();
                if (availableCoins >= quantity) {

                    availableCoins -= quantity;
                    AllData.getCoinObj().get(i).setCurrentSupply(availableCoins);

                    List<Traders> allTraders = AllData.getTraderObj();
                    Traders toAdd = null;
                    int index = -1;
                    for (int j = 0; j < allTraders.size(); j++) {
                        if (allTraders.get(j).getWalletAddress().equals(walletAddress)) {
                            toAdd = allTraders.get(j);
                            index = j;
                            break;
                        }
                    }

                    if (index == -1) {
                        return;
                    }

                    double currentPnL = AllData.getProfitLoss().get(walletAddress);
                    AllData.getProfitLoss().put(walletAddress, currentPnL - (quantity * price));
                    long previouslyHoldingQty = 0;
                    if (toAdd.getPortfolio().get(symbol) != null) {
                        previouslyHoldingQty = toAdd.getPortfolio().get(symbol);
                    }

                    long newHoldingQty = previouslyHoldingQty + quantity;
                    AllData.getTraderObj().get(index).getPortfolio().put(symbol, newHoldingQty);
                }
            }
        }
    }

    public static void sellCoins(String walletAddress, String symbol, long quantity, double price) {
        List<Coins> coinList = AllData.getCoinObj();
        for (int i = 0; i < coinList.size(); i++) {
            if (coinList.get(i).getSymbol().equals(symbol)) {
                long availableCoins = coinList.get(i).getCurrentSupply();
                if (availableCoins + quantity <= coinList.get(i).getCirculatingSupply()) {
                    availableCoins += quantity;
                    AllData.getCoinObj().get(i).setCurrentSupply(availableCoins);
                    double currentPnL = AllData.getProfitLoss().get(walletAddress);
                    double newPnL = currentPnL + (quantity * price);
                    AllData.getProfitLoss().put(walletAddress, newPnL);
                }
            }
        }
    }

    public static void addVolume(String symbol, long quantity)  {
        List<Coins> coinList = AllData.getCoinObj();
        for (int i = 0; i < coinList.size(); i++) {
            if (coinList.get(i).getSymbol().equals(symbol)) {
                long currentSupply = AllData.getCoinObj().get(i).getCurrentSupply();
                if (currentSupply + quantity <= coinList.get(i).getCirculatingSupply()) {
                    AllData.getCoinObj().get(i).setCurrentSupply(currentSupply + quantity);
                }
            }
        }
    }

    public static void changePrice(String symbol, double price) {
        List<Coins> coinList = AllData.getCoinObj();

        for (int i = 0; i < coinList.size(); i++) {
            if (coinList.get(i).getSymbol().equals(symbol)) {
                BigDecimal currentPrice = BigDecimal.valueOf(AllData.getCoinObj().get(i).getPrice());
                if (AllData.getTopCoins().containsKey(currentPrice)) {
                    AllData.getTopCoins().remove(currentPrice);
                    AllData.getTopCoins().put(BigDecimal.valueOf(price), symbol);
                }
                AllData.getCoinObj().get(i).setPrice(price);

            }
        }
    }
}
