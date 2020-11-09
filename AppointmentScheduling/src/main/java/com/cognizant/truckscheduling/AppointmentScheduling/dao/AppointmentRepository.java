package com.cognizant.truckscheduling.AppointmentScheduling.dao;

import com.cognizant.truckscheduling.AppointmentScheduling.model.AppointmentScheduling;
import com.cognizant.truckscheduling.AppointmentScheduling.model.DCSlots;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentScheduling,Integer> {

    @Query(value = "select count(*) from appointment_scheduling where  id=?1 and date_of_appointment=?2 ",nativeQuery = true)
    int truckCount(int timeSlot,String appointmentDate);

    @Query(value = "delete from appointment_scheduling where appointment_id=?1",nativeQuery = true)
     void deleteQuery(int appointmentId);

}
