package com.cognizant.truckscheduling.Vendor.service;

import com.cognizant.truckscheduling.Vendor.dao.VendorRepository;
import com.cognizant.truckscheduling.Vendor.exception.VendorExistException;
import com.cognizant.truckscheduling.Vendor.exception.VendorNotFoundException;
import com.cognizant.truckscheduling.Vendor.model.Vendor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class VendorService {
    @Autowired
    VendorRepository repository;
    @Value("${app.exception.vendorAvailable}")
    String vendorAvailable;
    @Value("${app.exception.vendorNotAvailable}")
    String vendorNotAvailable;


    //    @Cacheable(value = "vendor",key = "#vendorEmail")
    public Vendor addVendor(Vendor vendor) throws VendorExistException {
        if (repository.findByVendorEmail(vendor.getVendorEmail()).isPresent()) {
            throw new VendorExistException(vendorAvailable + " " + vendor.getVendorEmail());
        } else
            return repository.save(vendor);
    }

    @Cacheable(value = "vendor")
    public List<Vendor> getVendorList() {
        log.info("Inside vendors list ...");
        return repository.findAll();
    }

    //    @Cacheable(value = "vendor",key = "vendor.id")
    public Optional<Vendor> getVendorById(int id) throws VendorNotFoundException {

        if (repository.findById(id).isPresent()) {
            return repository.findById(id);
        } else
            throw new VendorNotFoundException(vendorNotAvailable + " " + id);
    }

    //    @Cacheable(value = "vendor",key = "#vendorEmail")
    public Optional<Vendor> getVendor(String mailId, Vendor vendor) throws VendorNotFoundException {

        if (repository.findByVendorEmail(mailId).isPresent()) {
            return repository.findByVendorEmail(mailId);
        } else
            throw new VendorNotFoundException(vendorNotAvailable + " " + mailId);
    }


    //    @CachePut(value = "vendor",key = "#id")
    public Vendor updateVendorById(int id, Vendor vendor) throws VendorNotFoundException {
        if (repository.findById(id).isPresent()) {
            Vendor updateVendor = repository.findById(id).get();
            updateVendor.setVendorId(vendor.getVendorId());
            updateVendor.setVendorName(vendor.getVendorName());
            updateVendor.setVendorEmail(vendor.getVendorEmail());
            updateVendor.setPhoneNumber(vendor.getPhoneNumber());
            updateVendor.setVendorAddress(vendor.getVendorAddress());
            return repository.save(updateVendor);
        } else
            throw new VendorNotFoundException(vendorNotAvailable + "  " + id);
    }


    public void deleteVendor(int id) throws VendorNotFoundException {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
        } else
            throw new VendorNotFoundException(vendorNotAvailable + " " + id);
    }

    public void deleteVendorDetails() {
        repository.deleteAll();
    }
}
