package com.cognizant.truckscheduling.Truck.dao;

import com.cognizant.truckscheduling.Truck.model.Truck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TruckRepository extends JpaRepository<Truck,Integer> {
    Optional<Truck> findByTruckNumber(Long truckNumber);
}
