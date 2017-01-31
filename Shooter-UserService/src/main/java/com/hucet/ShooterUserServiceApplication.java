package com.hucet;

import com.hucet.rabbitmq.properties.BindRabbitMQProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@EnableConfigurationProperties(BindRabbitMQProperties.class)
public class ShooterUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShooterUserServiceApplication.class, args);
    }
}
