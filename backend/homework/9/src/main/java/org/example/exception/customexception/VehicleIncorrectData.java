package org.example.exception.customexception;
/**
 * Exception class for Incorrect data
 */
public class VehicleIncorrectData extends RuntimeException{

    public VehicleIncorrectData(String vehicleIncorrectData)
    {
        super(vehicleIncorrectData);

    }
}
