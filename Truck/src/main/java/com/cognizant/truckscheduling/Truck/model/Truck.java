package com.cognizant.truckscheduling.Truck.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
//@IdClass(TruckId.class)
public class Truck {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private int truckId;
//    @Id
    private  Long truckNumber;
    private String truckName;
    private String truckType;
}
