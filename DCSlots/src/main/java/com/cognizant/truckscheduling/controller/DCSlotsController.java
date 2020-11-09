package com.cognizant.truckscheduling.controller;

import com.cognizant.truckscheduling.exception.SlotNotFoundException;
import com.cognizant.truckscheduling.model.DCSlots;
import com.cognizant.truckscheduling.service.DCSlotsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/dcSlots")
@Api(description = "Set of endpoints for Creating, Retrieving, Updating and Deleting DCSlots.")
public class DCSlotsController {

    @Autowired
    private DCSlotsService service;

    @ApiOperation("Returns list of all Slots.")
    @GetMapping
    public ResponseEntity<List<DCSlots>> getDCSlotsList(){

        return ResponseEntity.ok(service.getSlotsList());
    }

    @GetMapping("/{id}")
    @ApiOperation("Returns a specific slot by their identifier. 404 if does not exist.")
    public ResponseEntity<Optional<DCSlots>> getDCSlotById(@ApiParam("Id  to be obtained. Cannot be empty.")
                                                               @PathVariable int id) throws SlotNotFoundException {
        return  ResponseEntity.ok(service.getSlotById(id));
    }

    @PostMapping
    @ApiOperation("Creates a new DCslot.")
    public ResponseEntity<?> addDCSlots(@ApiParam("DCSlot information for a new slot to be created.") @RequestBody DCSlots dcSlots)  {
//        System.out.println("***********");
       System.out.println(dcSlots);
//        System.out.println(dcSlots.getDc());
        DCSlots dcSlot = service.addSlots(dcSlots);
        return  ResponseEntity.status(HttpStatus.CREATED).body(dcSlot);
//         return ResponseEntity.ok().build();
    }
    @PutMapping("/{id}")
    @ApiOperation("Updates a slot . 404 if the slot's identifier is not found.")
    public  ResponseEntity<?> updateSlot(@ApiParam("Id of the slot to be updated. Cannot be empty.") @RequestBody DCSlots dcSlots,@PathVariable int id) throws SlotNotFoundException {
        return ResponseEntity.ok(service.updateSlot(dcSlots,id));
    }
    @DeleteMapping("/{id}")
    @ApiOperation("Deletes a slot . 404 if the slot's identifier is not found.")
    public  ResponseEntity<?> deleteSlot(@ApiParam("Id of the slot to be deleted. Cannot be empty.") @PathVariable int id) throws SlotNotFoundException {
        service.deleteSlot(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public void deleteAll(){
        service.deleteAllSlots();
    }

}
