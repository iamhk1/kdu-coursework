package org.example.service;

import org.example.dto.VehicleDTO;
import org.example.models.Vehicle;
import org.example.repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepo vehicleRepo;
    public static void  addNewVehicle(VehicleDTO vehicleInDtoForm)
    {
        Vehicle vehicle=dtoToVehicle(vehicleInDtoForm);
        VehicleRepo.addVehicle(vehicle);

    }
    public static ResponseEntity<String> deleteVehicle(String vehicleName)
    {
        return VehicleRepo.deleteVehicle(vehicleName);

    }
    public static Vehicle getVehicle(String vehicleName)
    {
        return VehicleRepo.getVehicle(vehicleName);
    }
    public static ResponseEntity<String> updateVehicle(VehicleDTO vehicleInDtoForm)
    {
        Vehicle vehicle=dtoToVehicle(vehicleInDtoForm);
        return VehicleRepo.updateVehicle(vehicle);
    }
    /**
     *Here we convert the VehicleDTO to object of Vehicle class
     */
    public static Vehicle dtoToVehicle(VehicleDTO vehicleInDtoForm)
    {
        return new Vehicle(vehicleInDtoForm.getVehicleName(),vehicleInDtoForm.getPrice(),vehicleInDtoForm.getSpeaker(), vehicleInDtoForm.getTyre());

    }
    /**
     *Here we convert the  Vehicle class to vehicleDTO
     */
    public static VehicleDTO vehicleToDto(Vehicle vehicle)
    {
        return new VehicleDTO(vehicle.getVehicleName(),vehicle.getPrice(),vehicle.getSpeaker(),vehicle.getTyre());
    }


}
