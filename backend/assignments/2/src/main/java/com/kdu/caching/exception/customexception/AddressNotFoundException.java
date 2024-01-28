package com.kdu.caching.exception.customexception;

/**
 *Whenever an incorrect address or co-ordinates are encountered, this error is thrown
 */
public class AddressNotFoundException extends RuntimeException{
    public AddressNotFoundException(String addressNotFound)
    {
        super(addressNotFound);
    }
}
