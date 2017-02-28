package com.hucet.mail.security.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Configuration
public class WebProvider {
    @Value("${origin.host}")
    String originHost;

    @Value("${origin.port}")
    int originPort;

    @Bean("frontUrlBean")
    @Order(Ordered.HIGHEST_PRECEDENCE)
    String getUrl() {
        return "http://" + originHost + ":" + originPort;
    }
}
