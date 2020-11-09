package com.cognizant.truckscheduling.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class DCSlots implements Serializable {

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
    @ManyToOne
    @JoinColumn(name = "dc_number")
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private DC dc;

   @JsonIgnore
    public DC getDc() {
        return dc;
    }

    @JsonProperty
    public void setDc(DC dc) {
        this.dc = dc;
    }
}
