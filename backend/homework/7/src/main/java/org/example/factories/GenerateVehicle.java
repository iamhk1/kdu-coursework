package org.example.factories;

import org.example.entities.Speaker;
import org.example.entities.Tyre;
import org.example.entities.Vehicle;

public class GenerateVehicle {
    private GenerateVehicle()
    {

    }
    public static Vehicle generateNewVehicle(String name,  Speaker speaker,Tyre tyre,double price)
    {
        return new Vehicle(name,speaker,tyre,price);
    }
}
