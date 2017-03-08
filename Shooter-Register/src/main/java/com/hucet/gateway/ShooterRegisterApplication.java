package com.hucet.gateway;

import com.hucet.shared.annotation.EnableShooterBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
@EnableShooterBean
public class ShooterRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShooterRegisterApplication.class, args);
    }
}