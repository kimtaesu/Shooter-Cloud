package com.hucet.oauth2.service;

import com.hucet.oauth2.dto.AccountDto;
import com.hucet.oauth2.dto.Bar;
import com.hucet.oauth2.stream.FromSignupSink;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import rx.Observable;

/**
 * Created by taesu on 2017-02-13.
 */

public interface OAuthStreamService {
    @StreamListener
    void oauthReceiver(Observable<AccountDto> message);

    @Slf4j
    @EnableBinding(FromSignupSink.class)
    class Impl implements OAuthStreamService {

        @Autowired
        FromSignupSink source;

        @Override
        public void oauthReceiver(@Input(FromSignupSink.INPUT) Observable<AccountDto> message) {
            message.subscribe(s -> {
                log.info("******************");
                log.info("At the transformer");
                log.info("******************");
                log.info(s.toString());
            });
        }
    }
}
