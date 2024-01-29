package org.example.exception;

import org.example.dto.ErrorDTO;
import org.example.exception.customexception.EmptyListException;
import org.example.exception.customexception.UserAlreadyExistsException;
import org.example.exception.customexception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value={EmptyListException.class})
    public ResponseEntity<ErrorDTO> handleCustomException(EmptyListException ex)
    {
        ErrorDTO error=new ErrorDTO(ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value={UserAlreadyExistsException.class})
    public ResponseEntity<ErrorDTO> handleCustomException(UserAlreadyExistsException ex)
    {
        ErrorDTO error=new ErrorDTO(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value={UserNotFoundException.class})
    public ResponseEntity<ErrorDTO> handleCustomException(UserNotFoundException ex)
    {
        ErrorDTO error=new ErrorDTO(ex.getMessage(), HttpStatus.CONFLICT.value());
        return new ResponseEntity<>(error,HttpStatus.CONFLICT);
    }
}

