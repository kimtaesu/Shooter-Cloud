package com.hucet.security.exception;

/**
 * Created by taesu on 2017-02-28.
 */
public class AlreadyRegisteredException extends AbstractRestException {

    public AlreadyRegisteredException(String s) {
        super(s);
    }
}
