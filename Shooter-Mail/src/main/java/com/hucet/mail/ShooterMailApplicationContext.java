package com.hucet.mail;

import com.hucet.shared.ShooterBeanContext;
import com.hucet.shared.properties.ShooterProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

//@EnableDiscoveryClient
@SpringBootApplication
@Slf4j

public class ShooterMailApplicationContext extends ShooterBeanContext {
    public static void main(String[] args) {
        SpringApplication.run(ShooterMailApplicationContext.class, args);
    }
}
