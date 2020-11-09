package com.cognizant.truckscheduling.AppointmentScheduling.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Vendor implements Serializable {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int vendorId;
    @ApiModelProperty(hidden = true)
    private String vendorName;
    @ApiModelProperty(hidden = true)
    private String vendorEmail;
    @ApiModelProperty(hidden = true)
    private Long phoneNumber;

//    @JsonIgnore
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id")
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    private Address address;

    private String vendorAddress;

    @JsonIgnore
     @OneToMany(mappedBy = "vendor",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Set<AppointmentScheduling> appointmentScheduling;
}
