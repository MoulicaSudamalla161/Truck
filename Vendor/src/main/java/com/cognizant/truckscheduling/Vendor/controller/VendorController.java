package com.cognizant.truckscheduling.Vendor.controller;

import com.cognizant.truckscheduling.Vendor.exception.VendorExistException;
import com.cognizant.truckscheduling.Vendor.exception.VendorNotFoundException;
import com.cognizant.truckscheduling.Vendor.model.Vendor;
import com.cognizant.truckscheduling.Vendor.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/vendor")
public class VendorController {

    @Autowired
    private VendorService service;

    @PostMapping
    public ResponseEntity<?> addVendor(@RequestBody Vendor vendor) throws VendorExistException {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addVendor(vendor));
    }

    @GetMapping
    public ResponseEntity<List<Vendor>> getVendorList() {
        return ResponseEntity.ok(service.getVendorList());
    }

    @GetMapping("/getVendorById/{id}")
    public ResponseEntity<Optional<Vendor>> getVendorById(@PathVariable int id) throws VendorNotFoundException {
        return ResponseEntity.ok(service.getVendorById(id));
    }

    @GetMapping("/getVendorByMailId/{vendorEmail}")
    public ResponseEntity<Optional<Vendor>> getVendorByEmail(@PathVariable String vendorEmail, @RequestBody Vendor vendor) throws VendorNotFoundException {
        return ResponseEntity.ok(service.getVendor(vendorEmail, vendor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateVendor(@PathVariable int id, @RequestBody Vendor vendor) throws VendorNotFoundException {
        return ResponseEntity.ok(service.updateVendorById(id, vendor));
    }


    @DeleteMapping("/{vendorId}")
    public ResponseEntity<?> deleteVendorById(@PathVariable int vendorId) throws VendorNotFoundException {
        service.deleteVendor(vendorId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public void deleteVendor() {
        service.deleteVendorDetails();
    }
}
