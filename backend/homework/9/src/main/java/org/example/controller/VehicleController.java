package org.example.controller;
import jakarta.validation.Valid;
import org.example.dto.VehicleDTO;
import org.example.models.Vehicle;
import org.example.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RequestMapping("/vehicle")
@RestController
public class VehicleController {
    /**
     * Injecting vehicleService dependency in vehicleController
     */

    VehicleService vehicleService;
    @Autowired
    public VehicleController(VehicleService vehicleService)
    {
        this.vehicleService=vehicleService;
    }
    /**
     *For Post Request we will directly map our body data to out DTO object and then send it to vehicle service
     */
    @PostMapping("")
    public ResponseEntity<String>addVehicle(@Valid @RequestBody VehicleDTO vehicle)
    {

            VehicleService.addNewVehicle(vehicle);
            return ResponseEntity.ok("New Vehicle added Successfully");

    }
    /**
     *We take the vehicle name and fetch the vehicle object
     */
    @GetMapping("/{name}")
    public Vehicle getVehicle(@PathVariable  String name)
    {
        return VehicleService.getVehicle(name);

    }
    /**
     *We take the Vehicle name and delete that Vehicle object from the Vehicle Repository
     */
    @DeleteMapping("/{name}")
    public ResponseEntity<String>deleteVehicle(@PathVariable  @Valid String name)
    {

            VehicleService.deleteVehicle(name);
            return ResponseEntity.ok("OK");

    }
    /**
     *Updating the vehicle data with the new Vehicle Json that we get
     */
    @PutMapping("")
    public ResponseEntity<String>updateVehicle(@RequestBody @Valid VehicleDTO vehicle)
    {
         VehicleService.updateVehicle(vehicle);
         return ResponseEntity.ok("Vehicle updated Successfully");

    }
}
