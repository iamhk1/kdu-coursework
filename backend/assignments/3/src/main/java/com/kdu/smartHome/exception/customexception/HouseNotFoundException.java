package com.kdu.smartHome.exception.customexception;


public class HouseNotFoundException extends RuntimeException{
    public HouseNotFoundException(String ex)
    {
        super(ex);
    }
}
