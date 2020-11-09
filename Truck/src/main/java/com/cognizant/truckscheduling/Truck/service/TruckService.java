package com.cognizant.truckscheduling.Truck.service;

import com.cognizant.truckscheduling.Truck.dao.TruckRepository;
import com.cognizant.truckscheduling.Truck.exception.TruckAleadyExistException;
import com.cognizant.truckscheduling.Truck.exception.TruckNotFoundException;
import com.cognizant.truckscheduling.Truck.model.Truck;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TruckService {

    @Value("${app.exception.trucknotAvailable}")
    private String trucknotAvailable;
    @Value("${app.exception.truckAlreadyExist}")
    private String truckAlreadyExist;

    @Autowired
    TruckRepository repository;

    //    @Cacheable(value = "truck",key = "#truckNumber")
    public Truck addTruck(Truck truck) throws TruckAleadyExistException {
        if (repository.findByTruckNumber(truck.getTruckNumber()).isPresent())
            throw new TruckAleadyExistException(truckAlreadyExist + " " + truck.getTruckNumber());

        else
            return repository.save(truck);
    }

    @Cacheable(value = "truck")
    public List<Truck> getList() {
        log.info("Inside trucks list ...");
        return repository.findAll();
    }

    //    @Cacheable(key="#truckId",value = "truck")
    public Optional<Truck> getTruck(int id) throws TruckNotFoundException {
        if (repository.findById(id).isPresent())
            return repository.findById(id);
        else
            throw new TruckNotFoundException(trucknotAvailable + " " + id);


    }

    //    @CachePut(key="#truckId",value = "truck")
    public Truck updateTruck(int id, Truck truck) throws TruckNotFoundException {
        if (repository.findById(id).isPresent()) {
            Truck updatedTruck = repository.findById(id).get();
            updatedTruck.setTruckNumber(truck.getTruckNumber());
            updatedTruck.setTruckName(truck.getTruckName());
            updatedTruck.setTruckType(truck.getTruckType());

            return repository.save(updatedTruck);

        } else
            throw new TruckNotFoundException(trucknotAvailable + " " + id);
    }

    //    @CacheEvict(key="#truckId",value = "truck")
    public void deleteTruck(int id) throws TruckNotFoundException {
        if (repository.findById(id).isPresent())
            repository.deleteById(id);
        else
            throw new TruckNotFoundException(trucknotAvailable + " " + id);
    }

    public void deleteTrucks() {
        repository.deleteAll();
    }
}
