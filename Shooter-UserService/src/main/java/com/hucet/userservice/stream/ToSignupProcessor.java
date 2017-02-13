package com.hucet.userservice.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by taesu on 2017-02-13.
 */
public interface ToSignupProcessor {

    String OUTPUT = "to-signup";

    @Output(OUTPUT)
    MessageChannel output();
}
