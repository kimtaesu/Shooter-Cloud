package com.hucet.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
//@EnableDiscoveryClient
@EnableZuulProxy
public class ShooterGateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShooterGateWayApplication.class, args);
    }
}
