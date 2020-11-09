package com.cognizant.truckscheduling.AppointmentScheduling.controller;

import com.cognizant.truckscheduling.AppointmentScheduling.exception.*;
import com.cognizant.truckscheduling.AppointmentScheduling.model.AppointmentScheduling;
import com.cognizant.truckscheduling.AppointmentScheduling.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/scheduling")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Transactional
    @PostMapping
    public ResponseEntity<?>saveAppointment(@RequestBody AppointmentScheduling scheduling) throws PONotFoundException, SlotsFilledException, DCNotAvailableException, TruckNotFoundException, DCSlotNotFoundException, VendorNotFoundException {
        return ResponseEntity.ok(appointmentService.saveAppointment(scheduling));
    }

//    @GetMapping
//    public ResponseEntity<List<AppointmentScheduling>> getAppointmentList(){
//        return ResponseEntity.ok(appointmentService.getList());
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<AppointmentScheduling>> getAppointments(@PathVariable int id){
         return ResponseEntity.ok(appointmentService.getAppointments(id));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<?> modifyAppointment(@PathVariable int id,@RequestBody AppointmentScheduling appointmentScheduling)
    {
       return ResponseEntity.ok(appointmentService.modify(id,appointmentScheduling));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAppointment(@PathVariable int id){
        appointmentService.deleteAppointment(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public void deleteAll(){
        appointmentService.deleteScheduling();
    }

}
