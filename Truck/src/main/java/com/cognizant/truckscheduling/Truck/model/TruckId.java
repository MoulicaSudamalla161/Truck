package com.cognizant.truckscheduling.Truck.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TruckId implements Serializable {
    private int truckId;
    private  Long truckNumber;
}
