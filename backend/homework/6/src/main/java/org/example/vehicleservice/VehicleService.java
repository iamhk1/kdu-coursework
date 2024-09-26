package org.example.vehicleservice;
import org.example.beans.Speaker;
import org.example.beans.Tyre;
import org.example.beans.Vehicle;
import org.example.logs.Log;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class VehicleService {
    protected static List<Vehicle> allVehicle;

    public static void addToList(String name, Speaker s1, Tyre t1) {
        Vehicle newVehicle = new Vehicle(name, s1, t1);
        allVehicle.add(newVehicle);
    }

    @PostConstruct
    void postRun() {
        allVehicle = new ArrayList<>();
    }

    public static void topVehicle() {

        if (!allVehicle.isEmpty()) {
            Vehicle mostExpensive = allVehicle.stream()
                    .max(Comparator.comparingDouble(Vehicle::getPrice))
                    .orElse(null);
            if(mostExpensive!=null)
            {
                Log.info("Top Vehicle Details:");
                Log.info("Name :" + mostExpensive.getName());
                Log.info("Tyre Brand: " + mostExpensive.getTyre().getBrand());
                Log.info("Speaker Brand: " + mostExpensive.getSpeaker().getBrand());
                Log.info("Vehicle Price: $" + mostExpensive.getPrice());
            }
        }
    }
}