package com.cognizant.truckscheduling.POInformation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PODownload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int PONumber;
    private Date PODate;
    private  String POAddress;
    private String POLineNumber;
    private Long UPCNumber;
    private String UPCName;
    private  int orderedQuantity;

}
