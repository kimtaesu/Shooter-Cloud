package com.hucet.common.exception.client;


import com.hucet.common.exception.AbstractRestException;

public class DuplicatedFieldException extends AbstractRestException {
    public DuplicatedFieldException(String s) {
        super(s);
    }
}
