package org.example.exception.customexception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String s)
    {
        super(s);
    }
}
