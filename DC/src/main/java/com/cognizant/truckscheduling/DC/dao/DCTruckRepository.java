package com.cognizant.truckscheduling.DC.dao;

import com.cognizant.truckscheduling.DC.model.DC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DCTruckRepository extends JpaRepository<DC,Integer> {
}
