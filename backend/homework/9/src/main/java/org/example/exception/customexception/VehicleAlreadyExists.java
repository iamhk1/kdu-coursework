package org.example.exception.customexception;
/**
 * Exception class for vehicle that already are present
 */
public class VehicleAlreadyExists extends RuntimeException{

    public VehicleAlreadyExists(String vehicleExistsException)
    {
        super(vehicleExistsException);

    }

}
