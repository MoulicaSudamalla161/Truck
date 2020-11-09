package com.cognizant.truckscheduling.AppointmentScheduling.dao;

import com.cognizant.truckscheduling.AppointmentScheduling.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VendorRepository extends JpaRepository<Vendor,Integer> {
//    Vendor findByVendorEmail(String mailId);

    Vendor findByVendorName(String vendorName);

    Vendor findByVendorId(int vendorid);
}
