package com.hucet.rabbitmq.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

@Data
@ConfigurationProperties("spring.rabbitmq")
public class BindRabbitMQProperties {

    Map<String, BindingProperties> binding = new HashMap<>();

    @Data
    public static class BindingProperties {
        private String queue;
        private String exchange;
        private String rountingKey;
    }
}
