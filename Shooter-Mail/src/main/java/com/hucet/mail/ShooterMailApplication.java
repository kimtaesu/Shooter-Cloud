package com.hucet.mail;

import com.hucet.shared.config.CorsFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

//@EnableDiscoveryClient
@SpringBootApplication
@Slf4j
@Import(CorsFilter.class)
public class ShooterMailApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShooterMailApplication.class, args);
    }

}
