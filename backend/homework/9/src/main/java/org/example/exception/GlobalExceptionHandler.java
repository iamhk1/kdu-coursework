package org.example.exception;

import org.example.dto.ErrorDTO;
import org.example.exception.customexception.VehicleAlreadyExists;
import org.example.exception.customexception.VehicleIncorrectData;
import org.example.exception.customexception.VehicleNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(value={VehicleNotFound.class})
    public ResponseEntity<ErrorDTO> handleCustomException(VehicleNotFound ex)
    {
        ErrorDTO error=new ErrorDTO(ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value={VehicleIncorrectData.class})
    public ResponseEntity<ErrorDTO> handleCustomException(VehicleIncorrectData ex)
    {
        ErrorDTO error=new ErrorDTO(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value={VehicleAlreadyExists.class})
    public ResponseEntity<ErrorDTO> handleCustomException(VehicleAlreadyExists ex)
    {
        ErrorDTO error=new ErrorDTO(ex.getMessage(), HttpStatus.CONFLICT.value());
        return new ResponseEntity<>(error,HttpStatus.CONFLICT);
    }
    /**
     * HttpMessageNotReadable we are using @valid annotation for validation
     * If data is not returned in the correct format then this exception will be thrown
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDTO> handleException(HttpMessageNotReadableException ex) {
        ErrorDTO errorDTO = new ErrorDTO("Missing Fields in the JSON Body",HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorDTO,HttpStatus.NOT_ACCEPTABLE);
    }
}