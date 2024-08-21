package org.example.coin;

public class Coins {
    private int rank;
    private double price;
    private String name;
     private String symbol;
    private long currentSupply;
    private long circulatingSupply;
    public Coins()
    {

    }

    public Coins(int rank,String name,String symbol,double price,long circulatingSupply)
    {
        this.rank=rank;
        this.name=name;
        this.symbol=symbol;
        this.price=price;
        this.circulatingSupply=circulatingSupply;
        this.currentSupply=0;
    }

    public void setCurrentSupply(long currentSupply) {
        this.currentSupply = currentSupply;
    }

    public long getCurrentSupply() {
        return currentSupply;
    }

    public int getRank()
    {
        return rank;
    }
    public double getPrice()
    {
        return price;
    }
    public String getName()
    {
        return name;

    }
    public String getSymbol()
    {
        return symbol;
    }
    public long getCirculatingSupply()
    {
        return circulatingSupply;
    }
    public void setPrice(Double price)
    {
        this.price=price;
    }

}

