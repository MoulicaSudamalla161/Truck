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
//@IdClass(TruckId.class)
public class Truck implements Serializable  {

    @ApiModelProperty(hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int truckId;
    private  Long truckNumber;
    @ApiModelProperty(hidden = true)
    private String truckName;
    @ApiModelProperty(hidden = true)
    private String truckType;

     @JsonIgnore
     @OneToMany(mappedBy = "truck",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
     @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
     private Set<AppointmentScheduling >appointmentScheduling;
}