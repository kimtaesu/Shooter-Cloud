package com.hucet.microservice.dashboard;

import be.ordina.msdashboard.EnableMicroservicesDashboardServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableMicroservicesDashboardServer
@EnableEurekaClient
public class ShooterMicroserviceDashboardApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShooterMicroserviceDashboardApplication.class, args);
	}
}
