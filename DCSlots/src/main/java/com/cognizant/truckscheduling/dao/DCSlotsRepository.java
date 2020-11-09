package com.cognizant.truckscheduling.dao;

import com.cognizant.truckscheduling.model.DCSlots;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DCSlotsRepository extends CrudRepository<DCSlots , Integer> {
//    DC findById(int id);
}
