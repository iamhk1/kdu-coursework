package com.kdu.caching.exception;
import com.kdu.caching.dto.ErrorDTO;
import com.kdu.caching.exception.customexception.AddressNotFoundException;
import com.kdu.caching.exception.customexception.IllegalCoordinateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *Whenever an exception occurs, @ControllerAdvice will be automatically called
 */
@ControllerAdvice
public class GlobalExceptionHandler  {

    /**
     *Response to client in case of Illegal Co-ordinate Exception
     */
    @ExceptionHandler(IllegalCoordinateException.class)
    public ResponseEntity<ErrorDTO> handleException(IllegalCoordinateException ex) {
        ErrorDTO error=new ErrorDTO(ex.getMessage(), HttpStatus.CONFLICT.value());
        return new ResponseEntity<>(error,HttpStatus.CONFLICT);
    }

    /**
     *Response to client in case of Address Not Found Exception
     */
    @ExceptionHandler(AddressNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleException(AddressNotFoundException ex) {
        ErrorDTO error=new ErrorDTO(ex.getMessage(), HttpStatus.CONFLICT.value());
        return new ResponseEntity<>(error,HttpStatus.CONFLICT);
    }
}
