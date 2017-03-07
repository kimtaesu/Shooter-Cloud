package com.hucet.gateway;

import com.hucet.shared.config.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@Import(CorsFilter.class)
public class ShooterGateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShooterGateWayApplication.class, args);
    }
}
