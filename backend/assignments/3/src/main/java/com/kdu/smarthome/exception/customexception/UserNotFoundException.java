package com.kdu.smartHome.exception.customexception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String ex)
    {
        super(ex);
    }
}
