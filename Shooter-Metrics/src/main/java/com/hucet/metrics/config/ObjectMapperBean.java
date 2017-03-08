package com.hucet.metrics.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperBean {

    @Bean
    ObjectMapper objectMapper1() {
        return new ObjectMapper();
    }
}
