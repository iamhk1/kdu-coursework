package org.example.getdetails;

import org.example.entities.Vehicle;
import org.example.logs.Log;
import java.util.Comparator;
import java.util.List;

public class PrintDetails {
    private PrintDetails()
    {

    }
    public static void printMin(List<Vehicle> allVehicle)
    {
        Vehicle minPriceVehicle = allVehicle.stream()
                .min(Comparator.comparingDouble(Vehicle::getPrice))
                .orElse(null);
        if(minPriceVehicle!=null)
        {
            Log.info("Least Expensive Vehicle details are");
            Log.info(minPriceVehicle.getName()+" Name , "+minPriceVehicle.getPrice()+" Price , "+minPriceVehicle.getSpeaker().getBrand()+" Speaker ,  "+minPriceVehicle.getTyre().getBrand()+" Tyre");
        }
        else
        {
            Log.error("No Vehicle found");
        }
    }
    public static void printMax(List<Vehicle> allVehicle)
    {
        Vehicle minPriceVehicle = allVehicle.stream()
                .max(Comparator.comparingDouble(Vehicle::getPrice))
                .orElse(null);
        if(minPriceVehicle!=null)
        {
            Log.info("Most Expensive Vehicle details are");
            Log.info(minPriceVehicle.getName()+" Name , "+minPriceVehicle.getPrice()+" Price , "+minPriceVehicle.getSpeaker().getBrand()+" Speaker ,  "+minPriceVehicle.getTyre().getBrand()+" Tyre");
        }
        else
        {
            Log.error("No Vehicle found");
        }
    }
}
