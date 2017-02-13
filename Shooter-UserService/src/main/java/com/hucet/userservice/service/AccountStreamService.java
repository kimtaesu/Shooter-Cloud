package com.hucet.userservice.service;

import com.hucet.userservice.stream.ToSignupProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

/**
 * Created by taesu on 2017-02-13.
 */

public interface AccountStreamService {
//    @StreamListener
//    void accountReceiver(Observable<String> message);

    <T> void accountSend(T payload);

    @Slf4j
    @EnableBinding(ToSignupProcessor.class)
    class Impl implements AccountStreamService {

        @Autowired
        ToSignupProcessor source;

        @Override
        public <T> void accountSend(T payload) {
            source.output().send(MessageBuilder
                    .withPayload(payload)
                    .build());
        }
    }
}
