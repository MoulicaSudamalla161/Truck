package com.cognizant.kafkacloudstreamconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.cognizant.kafkacloudstreamconsumer.dao" )
@EnableBinding(Sink.class)
public class KafkaCloudStreamConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaCloudStreamConsumerApplication.class, args);
	}

}
