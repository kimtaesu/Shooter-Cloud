package com.hucet.mail.security.exception.handler;

import com.hucet.mail.security.exception.AbstractRestException;
import com.hucet.mail.security.exception.AlreadyRegisteredException;
import com.hucet.mail.security.exception.NotFountRoleItem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Component
public class GlobalExceptionHandler {
    @ExceptionHandler(value = AbstractRestException.class)
    public ResponseEntity<String> handleAbstractException(AbstractRestException e) {
        if (e instanceof AlreadyRegisteredException) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        } else if (e instanceof NotFountRoleItem) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
        }
        // TODO Catch NotRegisteredException, EmailExpiredTokenException
        return new ResponseEntity<>(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
    }
}
