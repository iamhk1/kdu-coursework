package org.example.controller;

import org.example.dto.VehicleDTO;
import org.example.models.Vehicle;
import org.example.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VehicleController {
    /**
     * Injecting vehicleService dependency in vehicleController
     */
    @Autowired
    VehicleService vehicleService;
    /**
     *For Post Request we will directly map our body data to out DTO object and then send it to vehicle service
     */
    @PostMapping("/vehicle")
    public ResponseEntity<String>addVehicle(@RequestBody VehicleDTO vehicle)
    {
        VehicleService.addNewVehicle(vehicle);
        return ResponseEntity.ok("New Vehicle added Successfully");
    }
    /**
     *We take the vehicle name and fetch the vehicle object
     */
    @GetMapping("/vehicle/{name}")
    public Vehicle getVehicle(@PathVariable String name)
    {
        return VehicleService.getVehicle(name);

    }
    /**
     *We take the Vehicle name and delete that Vehicle object from the Vehicle Repository
     */
    @DeleteMapping("/vehicle/{name}")
    public ResponseEntity<String>deleteVehicle(@PathVariable String name)
    {
        return VehicleService.deleteVehicle(name);

    }
    /**
     *Updating the vehicle data with the new Vehicle Json that we get
     */
    @PutMapping("/vehicle")
    public ResponseEntity<String>updateVehicle(@RequestBody VehicleDTO vehicle)
    {
        return VehicleService.updateVehicle(vehicle);

    }
}
