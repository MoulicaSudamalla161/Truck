package com.cognizant.truckscheduling.AppointmentScheduling.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PoInformation implements Serializable {
    @Id
    private  Long poNumber;
    @ApiModelProperty(hidden = true)
    private String poDate;
    @ApiModelProperty(hidden = true)
    private String poAddress;
    @ApiModelProperty(hidden = true)
    private int poLineNumber;
    @ApiModelProperty(hidden = true)
    private Long upcNumber;
    @ApiModelProperty(hidden = true)
    private  String upcName;
    @ApiModelProperty(hidden = true)
    private int orderedQuantity;

    @JsonIgnore
    @OneToMany(mappedBy = "poInformation",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Set<AppointmentScheduling> appointmentScheduling;


}
