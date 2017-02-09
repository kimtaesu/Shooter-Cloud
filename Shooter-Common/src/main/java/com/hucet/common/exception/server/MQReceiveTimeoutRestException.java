package com.hucet.common.exception.server;


import com.hucet.common.exception.AbstractRestException;

public class MQReceiveTimeoutRestException extends AbstractRestException {
    public MQReceiveTimeoutRestException(String s) {
        super(s);
    }
}
