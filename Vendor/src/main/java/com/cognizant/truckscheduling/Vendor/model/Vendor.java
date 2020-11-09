package com.cognizant.truckscheduling.Vendor.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Vendor {
       @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @JsonIgnore
       private  int vendorId;
       private String vendorName;
    private String vendorEmail;
    private Long phoneNumber;
    private String vendorAddress;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id")
//    private Address address;
}
