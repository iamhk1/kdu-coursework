package org.example.entities;
public class Vehicle {
    private Speaker speaker;
    private Tyre tyre ;
    double price;
    private String name;
    public Vehicle(String name,Speaker speaker, Tyre tyre,double price)
    {
        this.name=name;
        this.speaker=speaker;
        this.tyre=tyre;
        this.price=price+speaker.getPrice()+tyre.getPrice();
    }
    public String getName()
    {
        return this.name;
    }
    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    public Tyre getTyre() {
        return tyre;
    }

    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public double generateRandomPrice()
    {
        return Math.random()*1000+20000;

    }
}
