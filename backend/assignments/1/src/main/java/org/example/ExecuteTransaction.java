package org.example;

import org.example.alldata.AllData;
import org.example.coin.CoinOperations;
import org.example.coin.Coins;
import org.example.transaction.Transactions;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ExecuteTransaction implements Runnable{
    Transactions transaction;
    CountDownLatch latch;
    ExecuteTransaction(Transactions t, CountDownLatch l)
    {
        transaction=t;
        latch=l;
    }

    @Override
    public void run() {

            if(transaction.getType().equals("BUY"))
            {

                List<Coins> allCoins=AllData.getCoinObj();
                Coins obj=null;
                for(int i=0;i<allCoins.size();i++)
                {
                    if(allCoins.get(i).getSymbol().equals(transaction.getData().getCoin())){
                        obj=allCoins.get(i);
                        break;
                    }
                }

                String symbol=transaction.getData().getCoin();
                double price=0.0;
                for(Coins c:allCoins)
                {
                    if(c.getSymbol().equals(symbol))
                    {
                        price=c.getPrice();
                        break;
                    }
                }
                CoinOperations.buyCoins(obj,transaction.getData().getWalletAddress(),transaction.getData().getCoin(),transaction.getData().getQuantity(),price);
                latch.countDown();
            }
            else if(transaction.getType().equals("SELL"))
            {

                String symbol=transaction.getData().getCoin();
                List<Coins>allCoins=AllData.getCoinObj();
                double price=0.0;
                for(Coins c:allCoins)
                {
                    if(c.getSymbol().equals(symbol))
                    {
                        price=c.getPrice();
                        break;
                    }
                }
                CoinOperations.sellCoins(transaction.getData().getWalletAddress(),transaction.getData().getCoin(),transaction.getData().getQuantity(),price);
                latch.countDown();
            }
            else if(transaction.getType().equals("ADD_VOLUME"))
            {
                CoinOperations.addVolume(transaction.getData().getCoin(),transaction.getData().getVolume());
                latch.countDown();
            }
            else if(transaction.getType().equals("UPDATE_PRICE"))
            {
                CoinOperations.changePrice(transaction.getData().getCoin(),transaction.getData().getPrice());
                latch.countDown();
            }

    }
}
