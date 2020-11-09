package com.cognizant.truckscheduling.DC.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name="dc")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DC implements Serializable {

    @Id
    @Getter @Setter
   @Column(name ="dc_number")
    private int dcNumber;
    private String dcCity;
    private String dcType;



    @Override
    public String toString() {
        return "DC{" +
                "dcNumber=" + dcNumber +
                ", dcCity='" + dcCity + '\'' +
                ", dcType='" + dcType + '\'' +
                '}';
    }
}
