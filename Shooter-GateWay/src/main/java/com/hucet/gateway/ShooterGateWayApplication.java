package com.hucet.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@RestController
// Zuul 서버는 기본적으로 service name 을 통한 Loadbalance를 지원한다.
public class ShooterGateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShooterGateWayApplication.class, args);
    }

    @GetMapping
    String hello()
    {
        return "Hello";
    }
}
