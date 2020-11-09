package com.cognizant.truckscheduling.SchedulingInfo.service;

import com.cognizant.truckscheduling.SchedulingInfo.model.AppointmentScheduling;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {
    @StreamListener(Processor.INPUT)
    public void consumeMessage(AppointmentScheduling scheduling){
        System.out.println("Message received from kafka channel..");
        System.out.println(scheduling);


    }
}
