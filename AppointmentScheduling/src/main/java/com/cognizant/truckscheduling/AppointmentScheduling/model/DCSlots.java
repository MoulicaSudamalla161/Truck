package com.cognizant.truckscheduling.AppointmentScheduling.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
//@Data
@AllArgsConstructor
@NoArgsConstructor
public class DCSlots {

    @ApiModelProperty(hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String timeSlots;
    @ApiModelProperty(hidden = true)
    private int maxTrucks;

//ds_dc_number is the foreign key need to be created

    @JsonIgnore
    @ApiModelProperty(hidden = true)
    @ManyToOne(fetch = FetchType.LAZY,  cascade = CascadeType.MERGE)
    @JoinColumn(name = "dc_number")
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private DC dc;


    @JsonIgnore
    @OneToMany(mappedBy = "dcSlots", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Set<AppointmentScheduling> appointmentSchedulings;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(String timeSlots) {
        this.timeSlots = timeSlots;
    }

    public int getMaxTrucks() {
        return maxTrucks;
    }

    public void setMaxTrucks(int maxTrucks) {
        this.maxTrucks = maxTrucks;
    }

    public DC getDc() {
        return dc;
    }

    public void setDc(DC dc) {
        this.dc = dc;
    }

    public Set<AppointmentScheduling> getAppointmentSchedulings() {
        return appointmentSchedulings;
    }

    public void setAppointmentSchedulings(Set<AppointmentScheduling> appointmentSchedulings) {
        this.appointmentSchedulings = appointmentSchedulings;
    }


}
