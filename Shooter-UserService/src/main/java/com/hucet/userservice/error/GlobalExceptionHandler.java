package com.hucet.userservice.error;

import com.hucet.userservice.error.exception.AbstractException;
import com.hucet.userservice.error.exception.DuplicatedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value = AbstractException.class)
    public ResponseEntity<String> handleAbstractException(AbstractException e) {
        if (e instanceof DuplicatedException) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
    }
//    @ExceptionHandler(value = AbstractException.class)
//    public String handleException(Exception e){return e.getMessage();}


}