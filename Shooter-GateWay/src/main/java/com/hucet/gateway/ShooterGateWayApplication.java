package com.hucet.gateway;

import com.hucet.shared.annotation.EnableShooterBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@EnableShooterBean
public class ShooterGateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShooterGateWayApplication.class, args);
    }
}
