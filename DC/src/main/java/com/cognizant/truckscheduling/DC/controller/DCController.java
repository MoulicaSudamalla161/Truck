package com.cognizant.truckscheduling.DC.controller;

import com.cognizant.truckscheduling.DC.exception.SlotExistException;
import com.cognizant.truckscheduling.DC.exception.SlotNotAvailableException;
import com.cognizant.truckscheduling.DC.model.DC;
import com.cognizant.truckscheduling.DC.service.DCService;
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
 @RequestMapping("/v1/DC")
@Api(description = "Set of endpoints for Creating, Retrieving, Updating and Deleting DC's.")
public class DCController {

    @Autowired
    DCService service;
    @GetMapping
    @ApiOperation("Returns list of all DC's.")
    public ResponseEntity<List<DC>> getDCList(){
        return ResponseEntity.ok(service.getDC());
    }

    @GetMapping("/{dcNumber}")
    @ApiOperation("Returns a specific DC by their identifier. 404 if does not exist.")
    public ResponseEntity<DC> getDCListById(@ApiParam("Id  to be obtained. Cannot be empty.") @PathVariable int dcNumber) throws SlotNotAvailableException {

        return  ResponseEntity.ok( service.getDCList(dcNumber));

    }
    @PostMapping
    @ApiOperation("Creates a new DC.")
    public ResponseEntity<?> saveDCList(@ApiParam("DC information for a new DC to be created.") @RequestBody DC dc) throws SlotExistException {
         DC created= service.saveList(dc);
        return  ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    @PutMapping("/{dcNumber}")
    @ApiOperation("Updates a DC . 404 if the DC's identifier is not found.")
    public ResponseEntity<?> updateDC(@ApiParam("Id of the DC to be updated. Cannot be empty.")@PathVariable int dcNumber,@RequestBody DC dc) throws SlotNotAvailableException {
        return ResponseEntity.ok(  service.updateDC( dc, dcNumber));

    }

    @DeleteMapping("/{dcNumber}")
    @ApiOperation("Deletes a DC . 404 if the DC's identifier is not found.")
    public ResponseEntity<?> delete(@ApiParam("Id of the DC to be deleted. Cannot be empty.") @PathVariable int dcNumber) throws SlotNotAvailableException {
        service.deleteById(dcNumber);
        return   ResponseEntity.ok().build();

    }

    @DeleteMapping
    public void deleteAll() {
        service.deleteAllDC();
    }

}
