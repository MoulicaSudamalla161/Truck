package com.cognizant.kafkacloudstreamconsumer.service;

import com.cognizant.kafkacloudstreamconsumer.dao.PoInformationRepository;
import com.cognizant.kafkacloudstreamconsumer.model.PoInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    @Autowired
    private PoInformationRepository poInformationRepository;
    @StreamListener(Processor.INPUT)
    public void consumeMessage(PoInformation poInformation)  {
        poInformationRepository.save(poInformation);
    }

    public void deletePoInfo() {
        poInformationRepository.deleteAll();
    }
}
