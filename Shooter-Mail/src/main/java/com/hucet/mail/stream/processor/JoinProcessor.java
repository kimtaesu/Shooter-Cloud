package com.hucet.mail.stream.processor;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface JoinProcessor {
    String INPUT = "do-cert-mail";

    @Input(INPUT)
    SubscribableChannel input();
}
