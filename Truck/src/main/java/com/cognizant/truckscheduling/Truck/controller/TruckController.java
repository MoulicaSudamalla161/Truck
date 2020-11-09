package com.cognizant.truckscheduling.Truck.controller;

import com.cognizant.truckscheduling.Truck.exception.TruckAleadyExistException;
import com.cognizant.truckscheduling.Truck.exception.TruckNotFoundException;
import com.cognizant.truckscheduling.Truck.model.Truck;
import com.cognizant.truckscheduling.Truck.service.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/truck")
public class TruckController {
    @Autowired
    TruckService service;

    @GetMapping
    public ResponseEntity<List<Truck>> getTruckList() {
        return ResponseEntity.ok(service.getList());
    }

    @GetMapping("/getTruckById/{truckId}")
    public ResponseEntity<Optional<Truck>> getTruckById(@PathVariable int truckId) throws TruckNotFoundException {
        return ResponseEntity.ok(service.getTruck(truckId));
    }


    @PostMapping
    public ResponseEntity<?> addTruck(@RequestBody Truck truck) throws TruckNotFoundException, TruckAleadyExistException {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addTruck(truck));
    }


    @PutMapping("/{truckId}")
    public ResponseEntity<?> updateTruck(@PathVariable int truckId, @RequestBody Truck truck) throws TruckNotFoundException {
        return ResponseEntity.ok(service.updateTruck(truckId, truck));
    }


    @DeleteMapping("/{truckId}")
    public ResponseEntity<?> deleteTruck(@PathVariable int truckId) throws TruckNotFoundException {
        service.deleteTruck(truckId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public void deleteAllTrucks() {
        service.deleteTrucks();
    }

}
