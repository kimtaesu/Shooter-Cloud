package com.hucet.oauth2.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by taesu on 2017-02-13.
 */
public interface FromSignupSink {
    String INPUT = "from-signup";

    @Input(INPUT)
    SubscribableChannel input();
}
