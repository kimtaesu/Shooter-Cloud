package com.hucet.oauth2.stream.processor;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by taesu on 2017-02-13.
 */
public interface SignupProcessor {
    String INPUT = "from-signup";

    @Input(INPUT)
    SubscribableChannel input();

    String OUTPUT = "reply-signup";

    @Output(OUTPUT)
    MessageChannel output();
}
