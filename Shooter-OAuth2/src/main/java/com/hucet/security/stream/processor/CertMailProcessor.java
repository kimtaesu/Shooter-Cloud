package com.hucet.security.stream.processor;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by taesu on 2017-02-13.
 */
public interface CertMailProcessor {

    String OUTPUT = "notify-cert-mail";

    @Output(OUTPUT)
    MessageChannel output();
}
