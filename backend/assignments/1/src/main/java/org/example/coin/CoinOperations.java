
package org.example.coin;

import org.example.alldata.AllData;
import java.math.BigDecimal;
import java.util.List;

import Logs.Log;
import org.example.trader.Traders;

public class CoinOperations {
    public CoinOperations()
    {

    }
    public  void buyCoins(Coins obj, String walletAddress, String symbol, long quantity, double price) {
        int index=checkBuyPossible(symbol, quantity);
        if(index!=-1)
        {
            synchronized(this)
            {
                updateCoin(quantity, index,'-');
                updatePNL(walletAddress, symbol, quantity, price,'-');
                notifyAll();
            }

        }
        else {
            Log.info("Buy not possible");
        }

    }



    public  void sellCoins(String walletAddress, String symbol, long quantity, double price) {
        int index=checkSellPossible(symbol, quantity);
        if(index!=-1)
        {
            synchronized(this)
            {
                updateCoin(quantity, index,'+');
                updatePNL(walletAddress, symbol, quantity, price,'+');
                notifyAll();
            }

        }
        else{
            System.out.println("Not found");
            return;
        }
    }

    public  void addVolume(String symbol, long quantity)  {
        List<Coins> coinList = AllData.getCoinObj();
        int reqIndex=-1;
        for (int i = 0; i < coinList.size(); i++) {
            if (coinList.get(i).getSymbol().equals(symbol)) {
                reqIndex=i;
                break;
            }
        }
        long currentSupply = AllData.getCoinObj().get(reqIndex).getCurrentSupply();
        if (currentSupply + quantity <= coinList.get(reqIndex).getCirculatingSupply()) {
            AllData.getCoinObj().get(reqIndex).setCurrentSupply(currentSupply + quantity);
        }
    }

    public  void changePrice(String symbol, double price) {
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

    public int checkBuyPossible(String symbol,long quantity)
    {
        List<Coins> coinList = AllData.getCoinObj();
        for (int i = 0; i < coinList.size(); i++)
        {
            if (coinList.get(i).getSymbol().equals(symbol)) {
                long availableCoins = coinList.get(i).getCurrentSupply();
                if (availableCoins >= quantity) {
                    return i;
                }
                else {
                    try{
                        wait();
                    }
                    catch(Exception e)
                    {
                        Log.info("Exception "+e);
                    }
                }

            }
        }
        return -1;

    }
    public int checkSellPossible(String symbol,long quantity )
    {
        List<Coins> coinList = AllData.getCoinObj();
        for (int i = 0; i < coinList.size(); i++) {
            if (coinList.get(i).getSymbol().equals(symbol)) {
                long availableCoins = coinList.get(i).getCurrentSupply();
                ///check if those coins have been previously bought or not
                if (availableCoins + quantity <= coinList.get(i).getCirculatingSupply()) {
                    return i;
                }
                else{
                    try{
                        wait();
                    }
                    catch(Exception e)
                    {
                        Log.info("Exception"+e);
                    }
                }
            }
        }
        return -1;


    }


    public void updateCoin(long quantity,int i,char c)
    {
        List<Coins> coinList = AllData.getCoinObj();
        long availableCoins = coinList.get(i).getCurrentSupply();
        if(c=='-')
        {
            availableCoins -= quantity;
        }
        else
        {
            availableCoins += quantity;
        }

        AllData.getCoinObj().get(i).setCurrentSupply(availableCoins);

    }


    public void updatePNL(String walletAddress,String symbol,long quantity,double price,char ch)
    {
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
        if(index==-1)
        {
           Log.info("Trader with this wallet not found");
            return ;
        }

        double currentPnL = AllData.getProfitLoss().get(walletAddress);
        long newHoldingQty=0L;
        long previouslyHoldingQty = 0;
        if (toAdd.getPortfolio().get(symbol) != null) {
            previouslyHoldingQty = toAdd.getPortfolio().get(symbol);
        }
        if(ch=='-')/// when buy
        {
            AllData.getProfitLoss().put(walletAddress, currentPnL - (quantity * price));
            newHoldingQty = previouslyHoldingQty + quantity;

        }
        else ////when sell
        {
            AllData.getProfitLoss().put(walletAddress, currentPnL + (quantity * price));
            newHoldingQty = previouslyHoldingQty + quantity;
        }
        AllData.getTraderObj().get(index).getPortfolio().put(symbol, newHoldingQty);
    }

}
