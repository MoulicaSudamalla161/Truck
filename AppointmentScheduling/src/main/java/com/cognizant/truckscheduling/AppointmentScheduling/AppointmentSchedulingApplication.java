package com.cognizant.truckscheduling.AppointmentScheduling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableBinding(Source.class)
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.cognizant.truckscheduling.AppointmentScheduling.dao")
public class AppointmentSchedulingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppointmentSchedulingApplication.class, args);
	}

}
