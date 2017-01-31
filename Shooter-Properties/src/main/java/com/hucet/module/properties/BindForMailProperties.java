package com.hucet.module.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("spring.rabbitmq.binding.mail")
public class BindForMailProperties {
    private String queue;
    private String exchange;
    private String rountingKey;
}
