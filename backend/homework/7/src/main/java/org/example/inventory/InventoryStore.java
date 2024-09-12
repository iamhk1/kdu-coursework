package org.example.inventory;

import org.example.entities.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class InventoryStore {
    private List<Vehicle> allVehicle=new ArrayList<>();
    public List<Vehicle> getAllVehicle()
    {
        return allVehicle;
    }

    public void setAllVehicle(List<Vehicle> allVehicle) {
        this.allVehicle = allVehicle;
    }

}
