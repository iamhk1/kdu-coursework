package com.kdu.smartHome.exception;

import com.kdu.smartHome.dto.ErrorDTO;
import com.kdu.smartHome.exception.customexception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value={CustomException.class})
    public ResponseEntity<ErrorDTO> handleCustomException(CustomException ex)
    {
        ErrorDTO error=new ErrorDTO(ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value={UserNotFoundException.class})
    public ResponseEntity<ErrorDTO> userNotFound(UserNotFoundException ex)
    {
        ErrorDTO error=new ErrorDTO(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value={HouseNotFoundException.class})
    public ResponseEntity<ErrorDTO> userNotFound(HouseNotFoundException ex)
    {
        ErrorDTO error=new ErrorDTO(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value={DeviceNotFoundException.class})
    public ResponseEntity<ErrorDTO> deviceNotFound(DeviceNotFoundException ex)
    {
        ErrorDTO error=new ErrorDTO(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value={InvalidCredException.class})
    public ResponseEntity<ErrorDTO> invalidCred(InvalidCredException ex)
    {
        ErrorDTO error=new ErrorDTO(ex.getMessage(), HttpStatus.UNAUTHORIZED.value());
        return new ResponseEntity<>(error,HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(value={UnavailableDeviceException.class})
    public ResponseEntity<ErrorDTO> unavailableDevice(UnavailableDeviceException ex)
    {
        ErrorDTO error=new ErrorDTO(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}

