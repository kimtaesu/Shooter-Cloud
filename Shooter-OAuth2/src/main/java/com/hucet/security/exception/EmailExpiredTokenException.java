package com.hucet.security.exception;

/**
 * Created by taesu on 2017-02-28.
 */
public class EmailExpiredTokenException extends AbstractRestException {

    public EmailExpiredTokenException(String s) {
        super(s);
    }
}
