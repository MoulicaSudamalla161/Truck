package com.cognizant.truckscheduling.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DC implements Serializable {

    @Id
    @Column(name = "dc_number")
    private int dcNumber;
    @ApiModelProperty(hidden = true)
    private String dcCity;
    @ApiModelProperty(hidden = true)
    private String dcType;


       @JsonIgnore
    @OneToMany(mappedBy = "dc",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Set<DCSlots> dcSlots;

}
