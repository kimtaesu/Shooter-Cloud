package com.hucet.rabbitmq.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@Data
@EnableConfigurationProperties(ConnectionRabbitMQProperties.class)
@ConfigurationProperties("spring.rabbitmq")
public class ConnectionRabbitMQProperties {
    private String host;
    private int port;
    private String username;
    private String password;
    private String virtualHost;
}
