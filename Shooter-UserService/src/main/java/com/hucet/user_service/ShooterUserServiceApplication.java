package com.hucet.user_service;

import com.hucet.user_service.config.DatabaseInitializer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

//@EnableDiscoveryClient
@SpringBootApplication
// transaction 을 CGLIB 를 통해서 proxy를 생성하도록 수행
// @transaction interface 영역에서 동작을 하지 않기 때문에 선언
//@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ShooterUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShooterUserServiceApplication.class, args);
    }

    @Bean
    @Profile("init")
    CommandLineRunner commandLineRunner(DatabaseInitializer databaseInitializer) {
        return args -> {
            // Initialize the database for end to end integration testing
            databaseInitializer.populate();
        };
    }
}
