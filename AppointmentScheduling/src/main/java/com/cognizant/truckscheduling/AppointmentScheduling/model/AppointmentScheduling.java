package com.cognizant.truckscheduling.AppointmentScheduling.model;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentScheduling implements Serializable  {
     @ApiModelProperty(hidden = true)
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private  int appointmentId;
     private  String dateOfAppointment;

     @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
     @JoinColumn(name = "po_number")
     private PoInformation poInformation;

     @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
     @JoinColumn(name = "truck_number")
     private  Truck  truck;

     @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
     @JoinColumn(name="id")
     private DCSlots dcSlots;

     @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
     @JoinColumn(name = "dc_number")
     private DC dc1;


     @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
     @JoinColumn(name="vendor_id")
     private  Vendor vendor;


}
