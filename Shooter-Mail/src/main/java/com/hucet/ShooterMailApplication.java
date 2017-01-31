package com.hucet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ShooterMailApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShooterMailApplication.class, args);
	}
}
