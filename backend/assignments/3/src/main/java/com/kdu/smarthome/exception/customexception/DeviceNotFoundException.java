package com.kdu.smartHome.exception.customexception;

public class DeviceNotFoundException extends RuntimeException{
    public DeviceNotFoundException(String ex)
    {
        super(ex);
    }
}
