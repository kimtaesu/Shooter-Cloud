package com.hucet.userservice.exception;

import com.hucet.common.exception.AbstractRestException;
import com.hucet.common.exception.client.DuplicatedFieldException;
import com.hucet.common.exception.server.MQBindingConfigException;
import com.hucet.common.exception.server.MQReceiveTimeoutRestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value = AbstractRestException.class)
    public ResponseEntity<String> handleAbstractException(AbstractRestException e) {
        if (e instanceof DuplicatedFieldException) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } else if (e instanceof MQBindingConfigException) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } else if (e instanceof MQReceiveTimeoutRestException) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
    }
//    @ExceptionHandler(value = AbstractRestException.class)
//    public String handleException(Exception e){return e.getMessage();}


}