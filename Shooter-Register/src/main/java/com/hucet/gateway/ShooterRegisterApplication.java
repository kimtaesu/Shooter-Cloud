package com.hucet.gateway;

import com.hucet.shared.annotation.EnableShooterBean;
import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaServer
@EnableShooterBean
public class ShooterRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShooterRegisterApplication.class, args);
    }
}