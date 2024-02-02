package org.example.exceptions;

import org.example.dto.ErrorDTO;
import org.example.exceptions.customexception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     *
     * @param ex Exception we get
     * @return return a message and status code
     */
    @ExceptionHandler(value={CustomException.class})
    public ResponseEntity<ErrorDTO> handleCustomException(CustomException ex)
    {
        ErrorDTO error=new ErrorDTO(ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

}


