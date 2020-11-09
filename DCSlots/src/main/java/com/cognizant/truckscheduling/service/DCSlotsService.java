package com.cognizant.truckscheduling.service;

import com.cognizant.truckscheduling.dao.DCSlotsRepository;
import com.cognizant.truckscheduling.exception.SlotNotFoundException;
import com.cognizant.truckscheduling.model.DCSlots;
import com.cognizant.truckscheduling.model.TimeSlots;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class DCSlotsService {
    @Value("${app.exception.slotAlreadyAvailable}")
    private String slotExistMessage;
    @Value("${app.exception.slotNotAvailable}")
    private String slotNotAvailable;

    @Autowired
    private DCSlotsRepository repository;
    @Autowired
    DCSlotsRepository dcSlotsRepository;

    @Autowired
    private RestTemplate restTemplate;



    public List<DCSlots> getSlotsList() {
        return (List<DCSlots>) repository.findAll();
    }

    public DCSlots addSlots(DCSlots dcSlots) {

//        DC dc = new DC();
//        dc.setDcNumber(101);
       System.out.println(dcSlots);
         String DEFAULT_TIMESLOTS = TimeSlots.dcSlotsMethod(Integer.parseInt(dcSlots.getTimeSlots()),0);
          dcSlots.setTimeSlots(DEFAULT_TIMESLOTS);
//          dcSlots.setDc(dc);
        return repository.save(dcSlots);
    }

    public Optional<DCSlots> getSlotById(int id) throws SlotNotFoundException {

         if(repository.findById(id).isPresent()) {
             System.out.println(repository.findById(id).get().getId());
             return repository.findById(id);
         }
           else
             throw new SlotNotFoundException(slotNotAvailable + id);

    }

    public DCSlots updateSlot(DCSlots dcSlots, int id) throws SlotNotFoundException {
        if(repository.findById(id).isPresent()){
            DCSlots dc = repository.findById(id).get();
//            dc.setTimeSlots(dcSlots.getTimeSlots());
            String DEFAULT_TIMESLOTS = TimeSlots.dcSlotsMethod(Integer.parseInt(dcSlots.getTimeSlots()),0);
            dc.setTimeSlots(DEFAULT_TIMESLOTS);
            dc.setMaxTrucks(dcSlots.getMaxTrucks());
            return repository.save(dc);
        }
        else
            throw new SlotNotFoundException(slotNotAvailable+" "+id);
    }

    public void deleteSlot(int id) throws SlotNotFoundException {
        if(repository.findById(id).isPresent())
             repository.deleteById(id);
        else
            throw new SlotNotFoundException(slotNotAvailable+" "+id);
    }

    public void deleteAllSlots() {
        repository.deleteAll();
    }
}
