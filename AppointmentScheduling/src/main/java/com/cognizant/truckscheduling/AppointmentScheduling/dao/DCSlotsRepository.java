package com.cognizant.truckscheduling.AppointmentScheduling.dao;

import com.cognizant.truckscheduling.AppointmentScheduling.model.DC;
import com.cognizant.truckscheduling.AppointmentScheduling.model.DCSlots;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface DCSlotsRepository extends JpaRepository<DCSlots, Integer> {
    @Query(value = "select * from dcSlots where time_slots=?1 and dc_number=?2", nativeQuery = true)
//    @Query(value = "select * from dcSlots where time_slots=?1", nativeQuery = true)
    DCSlots findByTimeSlotsAndDc(String s, DC dc);
//    @Query(value = "select * from dcSlots where time_slots=?1",nativeQuery = true)
//    List<DCSlots> slots(String timeSlot);
}
