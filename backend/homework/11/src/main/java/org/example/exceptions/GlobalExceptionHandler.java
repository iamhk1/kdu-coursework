package org.example.exceptions;

import org.example.dto.ErrorDTO;
import org.example.exceptions.custom.GetException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(value={GetException.class})
    public ResponseEntity<ErrorDTO> handleCustomException(GetException ex)
    {
        ErrorDTO error=new ErrorDTO(ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

}