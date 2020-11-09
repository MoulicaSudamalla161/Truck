package com.cognizant.truckscheduling.SchedulingInfo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentScheduling {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int appointmentId;
    private  String dateOfAppointment;

//    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @JoinColumn(name = "apt_ponumber")
//    private PoInformation poInformation;
//
//    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @JoinColumn(name = "apt_truck")
//    private  Truck  truck;
//
//    @ManyToOne(cascade = CascadeType.MERGE)
//    @JoinColumn(name="apt_dc_slots")
//    private DCSlots dcSlots;
//
//    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @JoinColumn(name = "apt_dc_number")
//    private DC dc;
//
//    @ManyToOne
//    @JoinColumn(name="apt_vendor")
//    private  Vendor vendor;

}
