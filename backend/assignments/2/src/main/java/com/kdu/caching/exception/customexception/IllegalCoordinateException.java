package com.kdu.caching.exception.customexception;

/**
 *This is a basic check whether the co-ordinates passed are in a valid format or throw  an exception
 */
public class IllegalCoordinateException extends RuntimeException
{
    public IllegalCoordinateException(String illegalCoordinate)
    {
        super(illegalCoordinate);
    }
}
