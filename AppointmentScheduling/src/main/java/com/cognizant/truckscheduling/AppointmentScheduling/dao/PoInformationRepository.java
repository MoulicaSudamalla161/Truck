package com.cognizant.truckscheduling.AppointmentScheduling.dao;

import com.cognizant.truckscheduling.AppointmentScheduling.model.PoInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoInformationRepository extends JpaRepository<PoInformation,Long> {
    PoInformation findByPoNumber(Long poInformation);
}
