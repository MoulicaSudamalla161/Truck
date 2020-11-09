package com.cognizant.truckscheduling.AppointmentScheduling.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class DC  {

    @Id
    @Column(name = "dc_number")
    private int dcNumber;
    @ApiModelProperty(hidden = true)
    private String dcCity;
    @ApiModelProperty(hidden = true)
    private String dcType;


    @JsonIgnore
    @OneToMany(mappedBy = "dc1",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Set<AppointmentScheduling> appointmentScheduling;

    @JsonIgnore
    @OneToMany(mappedBy = "dc",fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Set<DCSlots> dcSlots;

    public int getDcNumber() {
        return dcNumber;
    }

    public void setDcNumber(int dcNumber) {
        this.dcNumber = dcNumber;
    }

    public String getDcCity() {
        return dcCity;
    }

    public void setDcCity(String dcCity) {
        this.dcCity = dcCity;
    }

    public String getDcType() {
        return dcType;
    }

    public void setDcType(String dcType) {
        this.dcType = dcType;
    }

    public Set<AppointmentScheduling> getAppointmentScheduling() {
        return appointmentScheduling;
    }

    public void setAppointmentScheduling(Set<AppointmentScheduling> appointmentScheduling) {
        this.appointmentScheduling = appointmentScheduling;
    }

    public Set<DCSlots> getDcSlots() {
        return dcSlots;
    }

    public void setDcSlots(Set<DCSlots> dcSlots) {
        this.dcSlots = dcSlots;
    }


}
