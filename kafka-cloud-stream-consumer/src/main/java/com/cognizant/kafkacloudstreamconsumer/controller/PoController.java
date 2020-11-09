package com.cognizant.kafkacloudstreamconsumer.controller;

import com.cognizant.kafkacloudstreamconsumer.model.PoInformation;
import com.cognizant.kafkacloudstreamconsumer.service.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/poInformation")
public class PoController {
    @Autowired
    MessageListener listener;
    @PostMapping
    public void createPo(@RequestBody  PoInformation poInformation){
         listener.consumeMessage(poInformation);
    }
    @DeleteMapping
    public void deletePo(){
        listener.deletePoInfo();
    }
}
