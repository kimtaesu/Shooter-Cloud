package com.hucet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ShooterOAuth2Application {

    public static void main(String[] args) {
        SpringApplication.run(ShooterOAuth2Application.class, args);
    }
}
