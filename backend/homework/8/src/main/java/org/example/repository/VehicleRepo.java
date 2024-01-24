package org.example.repository;

import org.example.models.Vehicle;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepo {
    private static List<Vehicle>allVehicle=new ArrayList<>();
    public List<Vehicle>getVehicleList()
    {
        return allVehicle;
    }
    /**
     *Adding a new vehicle
     */
    public static void addVehicle(Vehicle newVehicle)
    {
        allVehicle.add(newVehicle);
    }
    /**
     *We check if our allVehicle list contains a vehicle with the given name
     * If found , we delete it else we send a Response entity with error message
     */
    public static ResponseEntity<String> deleteVehicle(String vehicleName)
    {
        int index=0;
        for(index=0;index<allVehicle.size();index++)
        {
            if(allVehicle.get(index).getVehicleName().equals(vehicleName))
                break;
        }
        if(index>=allVehicle.size()){
            return ResponseEntity.ok("Vehicle Not Found");
        }
        else
        {
            allVehicle.remove(index);
            return ResponseEntity.ok("Vehicle Deleted Successfully");
        }
    }
    /**
     *Here we have a pre assumption that the vehicle object that we are getting , we get the original vehicle name
     * Rest all the parameters need to be changed
     * If vehicle with that name is not found then we return an error message
     */
    public static ResponseEntity<String> updateVehicle(Vehicle vehicle)
    {
        Vehicle toUpdateVehicle=null;
        int index=-1;
        for(int i=0;i<allVehicle.size();i++)
        {
            if(allVehicle.get(i).getVehicleName().equals(vehicle.getVehicleName())) {
                toUpdateVehicle=allVehicle.get(i);
                index=i;
                break;
            }
        }
        if(toUpdateVehicle==null){
            return ResponseEntity.ok("Vehicle Not Found");
        }
        else
        {
            toUpdateVehicle.setPrice(vehicle.getPrice());
            toUpdateVehicle.setTyre(vehicle.getTyre());
            toUpdateVehicle.setSpeaker(vehicle.getSpeaker());
            allVehicle.set(index,toUpdateVehicle);
            return ResponseEntity.ok("Vehicle Updated Successfully");

        }
    }
    /**
     *We get a String name and we search for the vehicle
     * If vehicle is not found
     */
    public static Vehicle getVehicle(String vehicleName)
    {

        for(Vehicle eachVehicle:allVehicle)
        {
            if(eachVehicle.getVehicleName().equals(vehicleName)) {

                return eachVehicle;
            }

        }
        return null;
    }

}
