package com.cognizant.kafkacloudstreamproducer.controller;

import com.cognizant.kafkacloudstreamproducer.model.PoInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/PoInformation")
public class ProducerController {

    @Autowired
    private MessageChannel output;
    @PostMapping
    public void register(@RequestBody PoInformation poInformation) {
//        System.out.println("User:" +poInformation);
        Message<PoInformation> message = MessageBuilder.withPayload(poInformation).build();
         output.send(message);
//        System.out.println("Data::" +data);

    }
}
