package com.hucet.mail;

import com.hucet.shared.annotation.EnableShooterBean;
import com.hucet.shared.properties.ShooterProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableDiscoveryClient
@SpringBootApplication
@Slf4j
@EnableShooterBean
public class ShooterMailApplicationContext {
    public static void main(String[] args) {
        SpringApplication.run(ShooterMailApplicationContext.class, args);
    }
}
