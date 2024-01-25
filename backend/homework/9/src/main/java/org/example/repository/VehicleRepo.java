package org.example.repository;
import lombok.extern.slf4j.Slf4j;
import org.example.exception.customexception.VehicleAlreadyExists;
import org.example.exception.customexception.VehicleIncorrectData;
import org.example.exception.customexception.VehicleNotFound;
import org.example.models.Vehicle;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Slf4j
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
        for(Vehicle vehicle:allVehicle)
        {
            if(vehicle.getVehicleName().equals(newVehicle.getVehicleName())) {
                log.error("Vehicle already exists");
                throw new VehicleAlreadyExists("Vehicle with this name already exists");
            }
        }
        allVehicle.add(newVehicle);
        log.info("Vehicle added Succesfully");
    }
    /**
     *We check if our allVehicle list contains a vehicle with the given name
     * If found , we delete it else we send a Response entity with error message
     */
    public static void  deleteVehicle(String vehicleName)
    {
        int index=0;
        for(index=0;index<allVehicle.size();index++)
        {
            if(allVehicle.get(index).getVehicleName().equals(vehicleName))
                break;
        }
        if(index>=allVehicle.size()){
            log.error("Vehicle with the given name was not found");
            throw new VehicleNotFound("Vehicle does not exist in the Database");
        }
        else
        {
            allVehicle.remove(index);
            log.info("Vehicle was deleted successfully");

        }
    }
    /**
     *Here we have a pre assumption that the vehicle object that we are getting , we get the original vehicle name
     * Rest all the parameters need to be changed
     * If vehicle with that name is not found then we return an error message
     */
    public static void  updateVehicle(Vehicle vehicle)
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
            log.error("Vehicle with these details was not found");
            throw new VehicleIncorrectData("Vehicle data not provided properly");
        }
        else
        {
            toUpdateVehicle.setVehicleName(vehicle.getVehicleName());
            toUpdateVehicle.setVehiclePrice(vehicle.getVehiclePrice());
            toUpdateVehicle.getSpeaker().setSpeakerName(vehicle.getSpeaker().getSpeakerName());
            toUpdateVehicle.getSpeaker().setSpeakerPrice(vehicle.getSpeaker().getSpeakerPrice());
            toUpdateVehicle.getTyre().setTyreName(vehicle.getTyre().getTyreName());
            toUpdateVehicle.getTyre().setTyrePrice(vehicle.getTyre().getTyrePrice());
            toUpdateVehicle.setSpeaker(vehicle.getSpeaker());
            allVehicle.set(index,toUpdateVehicle);
            log.info("Vehicle updated Successfully");
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
        throw new VehicleNotFound("Cannot get vehicle with this name");
    }

}
