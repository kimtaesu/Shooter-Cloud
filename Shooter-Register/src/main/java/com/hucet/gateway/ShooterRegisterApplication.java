package com.hucet.gateway;

import com.hucet.shared.config.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableEurekaServer
@Import(CorsFilter.class)
public class ShooterRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShooterRegisterApplication.class, args);
    }
}