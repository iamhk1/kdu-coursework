package org.example.service;

import org.example.dto.VehicleDTO;
import org.example.models.Speaker;
import org.example.models.Tyre;
import org.example.models.Vehicle;
import org.example.repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

     VehicleRepo vehicleRepo;
    @Autowired
    public VehicleService(VehicleRepo vehicleRepo)
    {
        this.vehicleRepo=vehicleRepo;
    }
    public static void  addNewVehicle(VehicleDTO vehicleInDtoForm)
    {

        Vehicle vehicle=dtoToVehicle(vehicleInDtoForm);
        VehicleRepo.addVehicle(vehicle);

    }
    public static void deleteVehicle(String vehicleName)
    {
         VehicleRepo.deleteVehicle(vehicleName);

    }
    public static Vehicle getVehicle(String vehicleName)
    {

        return VehicleRepo.getVehicle(vehicleName);
    }
    public static void updateVehicle(VehicleDTO vehicleInDtoForm)
    {
        Vehicle vehicle=dtoToVehicle(vehicleInDtoForm);
         VehicleRepo.updateVehicle(vehicle);
    }
    /**
     *Here we convert the VehicleDTO to object of Vehicle class
     */
    public static Vehicle dtoToVehicle(VehicleDTO vehicleInDtoForm)
    {
        Speaker newSpeaker=new Speaker(vehicleInDtoForm.getSpeakerName(),vehicleInDtoForm.getSpeakerPrice());
        Tyre newTyre =new Tyre(vehicleInDtoForm.getTyreName(),vehicleInDtoForm.getTyrePrice());
        return new Vehicle(vehicleInDtoForm.getVehicleName(),vehicleInDtoForm.getVehiclePrice(),newTyre,newSpeaker);

    }
    /**
     *Here we convert the  Vehicle class to vehicleDTO
     */
    public static VehicleDTO vehicleToDto(Vehicle vehicle)
    {
        return new VehicleDTO(vehicle.getVehicleName(),vehicle.getVehiclePrice(),vehicle.getTyre().getTyreName(),vehicle.getTyre().getTyrePrice(),vehicle.getSpeaker().getSpeakerName(),vehicle.getSpeaker().getSpeakerPrice());
    }


}
