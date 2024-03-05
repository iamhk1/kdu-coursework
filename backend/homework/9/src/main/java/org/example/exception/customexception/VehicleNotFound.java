package org.example.exception.customexception;
/**
 * Exception class for vehicle not found
 */
public class VehicleNotFound extends RuntimeException{
    public VehicleNotFound(String vehicleNotFoundException)
    {
        super(vehicleNotFoundException);
    }
}
