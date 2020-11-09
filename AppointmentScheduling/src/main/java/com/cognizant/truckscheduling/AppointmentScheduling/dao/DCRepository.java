package com.cognizant.truckscheduling.AppointmentScheduling.dao;

import com.cognizant.truckscheduling.AppointmentScheduling.model.DC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.concurrent.Future;

@Repository
public interface DCRepository extends JpaRepository<DC,Integer> {
    DC findByDcNumber(int dcNumber);

    DC findByDcCity(String dcNumber);
}
