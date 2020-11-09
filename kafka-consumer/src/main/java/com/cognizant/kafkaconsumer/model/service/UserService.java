package com.cognizant.kafkaconsumer.model.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @KafkaListener(topics = "SpringTestTopic", groupId = "my-app", containerFactory = "kafkaListenerContainerFactory")
    public void listenToKafkaTopic() {
        System.out.println("Message received from Kafka topic is  ::::  ");

//        System.out.println(user);
    }
}