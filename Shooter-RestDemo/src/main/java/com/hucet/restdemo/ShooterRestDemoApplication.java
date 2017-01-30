package com.hucet.restdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/test")
@EnableDiscoveryClient
@SpringBootApplication
public class ShooterRestDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShooterRestDemoApplication.class, args);
    }

    @GetMapping("/test")
    String test() {
        return "test";
    }

    @GetMapping("/join")
    String join() {
        return "join";
    }
}
