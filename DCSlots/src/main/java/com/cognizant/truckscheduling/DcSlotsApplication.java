package com.cognizant.truckscheduling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.cognizant.truckscheduling.dao")
@EnableEurekaClient
public class DcSlotsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DcSlotsApplication.class, args);
	}



}
