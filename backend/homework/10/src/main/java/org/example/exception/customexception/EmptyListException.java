package org.example.exception.customexception;

public class EmptyListException extends RuntimeException{
    public EmptyListException(String s)
    {
        super(s);
    }
}
