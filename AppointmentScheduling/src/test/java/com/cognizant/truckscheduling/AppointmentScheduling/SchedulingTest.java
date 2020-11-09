package com.cognizant.truckscheduling.AppointmentScheduling;


import com.cognizant.truckscheduling.AppointmentScheduling.model.*;
import com.fasterxml.jackson.databind.JsonNode;
import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SchedulingTest {
    String dcUrl = "http://localhost:8081/v1/DC";
    String dcSlotUrl = "http://localhost:8082/v1/dcSlots";
    String truckUrl = "http://localhost:8084/v1/truck";
    String vendorUrl = "http://localhost:8083/v1/vendor";
    String poUrl = "http://localhost:8090/v1/poInformation";
    String schedulingUrl = "http://localhost:8086/v1/scheduling";
    @Value("${app.value.dcNumber}")
    private  int dcNumber;
    @Value("${app.value.timeSlot}")
    private  String timeSlot;
    @Value("${app.value.truckNumber}")
    private  Long truckNumber;
    @Value("${app.value.vendorNumber}")
    private  int vendorNumber;
    @Value("${app.value.poNumber}")
    private  Long poNumber;
    @Value("${app.value.appointmentDate}")
    private String appointmentDate;

    RestTemplate template = new RestTemplate();

    DC dcData(){
        DC dc = new DC();
        dc.setDcNumber(dcNumber);
        dc.setDcCity("Bangalore");
        dc.setDcType("Imports");
        return  dc;
    }
    DCSlots dcSlotsData(){
//        DC dc = new DC();
//        dc.setDcNumber(101);
//        DC updated=dc;
        DCSlots dcSlots = new DCSlots();
        dcSlots.setDc(dcData());
        dcSlots.setTimeSlots(timeSlot);
        dcSlots.setMaxTrucks(2);
        return  dcSlots;
    }
    Truck truckData(){
        Truck truck = new Truck();
        truck.setTruckNumber(truckNumber);
        truck.setTruckName("AP31 7402");
        truck.setTruckType("Conestoga Trailers");
        return truck;
    }
    Vendor vendorData(){
        Vendor vendor = new Vendor();
        vendor.setVendorId(vendorNumber);
        vendor.setVendorName("Madhu");
        vendor.setVendorEmail("abc@gmail.com");
        vendor.setPhoneNumber(7036133542L);
        vendor.setVendorAddress("Visakhapatnam");
        return vendor;
    }
    PoInformation poData(){
        PoInformation poInformation = new PoInformation();
        poInformation.setPoNumber(poNumber);
        poInformation.setPoDate("31/10/2020");
        poInformation.setPoLineNumber(2);
        poInformation.setOrderedQuantity(2);
        poInformation.setPoAddress("Chennai");
        poInformation.setUpcNumber(9876543L);
        poInformation.setUpcName("Shoes");
        return poInformation;
    }
    AppointmentScheduling schedulingData(){
        AppointmentScheduling scheduling = new AppointmentScheduling();
        scheduling.setDateOfAppointment(appointmentDate);
        scheduling.setDc1(dcData());
        scheduling.setDcSlots(dcSlotsData());
        scheduling.setPoInformation(poData());
        scheduling.setVendor(vendorData());
        scheduling.setTruck(truckData());


        return scheduling;
    }
    public void insertDetails(){
       ResponseEntity<DC> dc= template.postForEntity(dcUrl,dcData(), DC.class) ;
//        System.out.println(dcSlotsData());
//        ResponseEntity<DCSlots> dcSlots = template.postForEntity(dcSlotUrl,dcSlotsData(), DCSlots.class) ;
//        System.out.println(dcSlots);
        ResponseEntity<Truck> truck = template.postForEntity(truckUrl, truckData(), Truck.class);
       ResponseEntity<Vendor> vendor = template.postForEntity(vendorUrl, vendorData(), Vendor.class);
        ResponseEntity<PoInformation> poInformation = template.postForEntity(poUrl,poData(),PoInformation.class);
//        ResponseEntity<AppointmentScheduling> scheduling = template.postForEntity(schedulingUrl,schedulingData(),AppointmentScheduling.class);
    }
    public void deleteDetails(){
//        template.delete(schedulingUrl);
        template.delete(poUrl);
        template.delete(truckUrl);
        template.delete(vendorUrl);
//        template.delete(dcSlotUrl);
        template.delete(dcUrl);
    }

    @Test
    @Rollback(false)
    public  void createAppointmentTest(){
//      deleteDetails();
//        insertDetails();
        ResponseEntity<AppointmentScheduling> scheduling = template.postForEntity(schedulingUrl,schedulingData(),AppointmentScheduling.class);
//        System.out.println(scheduling);
//        assertNotNull(scheduling);



    }

    @Test
    @Rollback(false)
    public void deleteAppointmentTest(){
        deleteDetails();
        insertDetails();
        ResponseEntity<AppointmentScheduling> scheduling = template.postForEntity(schedulingUrl,schedulingData(),AppointmentScheduling.class);
        template.delete(schedulingUrl+"/"+scheduling.getBody().getAppointmentId());
    }

    @Test
    public void getAppointentTest(){
        deleteDetails();
        insertDetails();
        ResponseEntity<AppointmentScheduling[]> scheduling = template.getForEntity(schedulingUrl,AppointmentScheduling[].class);
        List<AppointmentScheduling> result= Arrays.asList(scheduling.getBody());
        for (AppointmentScheduling scheduling1: result)
            System.out.println(scheduling1);
//        AssertionsForInterfaceTypes.assertThat(result).size().isGreaterThan(0);
    }
}
