package com.hucet.common.exception.server;


import com.hucet.common.exception.AbstractRestException;

public class BusinessException extends AbstractRestException {
    public BusinessException(String s) {
        super(s);
    }
}
