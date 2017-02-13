package com.hucet.userservice.stream;

import com.hucet.userservice.stream.processor.SignupProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;
import rx.Observable;

/**
 * Created by taesu on 2017-02-13.
 */

public interface AccountStreamService {

    <T> void accountSend(T payload);

    @StreamListener
    void onReply(Observable<Boolean> in);

    @Slf4j
    @EnableBinding(SignupProcessor.class)
    class Impl implements AccountStreamService {

        @Autowired
        SignupProcessor source;

        @Override
        public <T> void accountSend(T payload) {
            source.output().send(MessageBuilder
                    .withPayload(payload)
                    .build());
        }

        @Override
        public void onReply(@Input(SignupProcessor.INPUT) Observable<Boolean> in) {
            in.subscribe(s -> {
                log.info("onReply " + s);
            });
        }
    }
}
