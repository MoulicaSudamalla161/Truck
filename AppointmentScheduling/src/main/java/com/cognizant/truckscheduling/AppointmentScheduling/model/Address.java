package com.cognizant.truckscheduling.AppointmentScheduling.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @Column(name = "address_id")
    private String vendorEmail;
    private String streetName;
    private String city;
    private  int zipCode;
    private  String state;
    private String country;
}
