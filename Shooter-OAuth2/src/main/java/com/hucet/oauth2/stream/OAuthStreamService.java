package com.hucet.oauth2.stream;

import com.hucet.oauth2.dto.AccountDto;
import com.hucet.oauth2.service.OAuth2UserService;
import com.hucet.oauth2.stream.processor.SignupProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import reactor.core.publisher.Flux;

/**
 * Created by taesu on 2017-02-13.
 */

public interface OAuthStreamService {
    @StreamListener
    @Output(SignupProcessor.OUTPUT)
    Flux<Boolean> oauthStream(Flux<AccountDto> in);

    @Slf4j
    @EnableBinding(SignupProcessor.class)
    class Impl implements OAuthStreamService {

        @Autowired
        SignupProcessor source;

        @Autowired
        OAuth2UserService oAuth2UserService;

        @Override
        public Flux<Boolean> oauthStream(@Input(SignupProcessor.INPUT) Flux<AccountDto> in) {
            return in
                    .map(accountDto -> {
                        log.info(accountDto.toString());
                        return oAuth2UserService.addOAuth2User(accountDto);
                    });
        }
    }
}
