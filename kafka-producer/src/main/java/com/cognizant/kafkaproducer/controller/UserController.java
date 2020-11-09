package com.cognizant.kafkaproducer.controller;

import com.cognizant.kafkaproducer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Value("${kafka.topic}")
    private  String topicName;

    @Autowired
    private KafkaTemplate<String,User> kafkaTemplate;
    @PostMapping("/home")
    public void home(@RequestBody User user){
//        String str=  "Hello Kafka......";

        //send data to a topic...
        kafkaTemplate.send(topicName,user);
//        return  "Success sent data to kafka....";
    }
}
