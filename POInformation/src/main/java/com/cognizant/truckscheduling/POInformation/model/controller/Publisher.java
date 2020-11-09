package com.cognizant.truckscheduling.POInformation.model.controller;

import com.cognizant.truckscheduling.POInformation.model.PODownload;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

import java.io.InputStream;
import java.util.List;

public class Publisher {
    @Value("${kafka.topic}")
    private  String topicName;

    @Autowired
    private KafkaTemplate<String, PODownload> kafkaTemplate;



    public String display(){

//        ObjectMapper mapper = new ObjectMapper();
//        TypeReference<List<PODownload>> typeReference = new TypeReference<List<PODownload>>(){};
//        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/users.json");
//        mapper.readValue(inputStream,typeReference);
        kafkaTemplate.send(topicName,)
    }
}
