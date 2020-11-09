package com.cognizant.truckscheduling.Vendor.dao;

import com.cognizant.truckscheduling.Vendor.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VendorRepository extends JpaRepository<Vendor,Integer> {
    Optional<Vendor> findByVendorEmail(String mailId);
}
