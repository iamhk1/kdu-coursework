package org.example.exception.customexception;

public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException(String s)
    {
        super(s);
    }
}
