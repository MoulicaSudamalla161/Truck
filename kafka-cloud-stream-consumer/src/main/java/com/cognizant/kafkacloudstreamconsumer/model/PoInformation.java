package com.cognizant.kafkacloudstreamconsumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PoInformation {
    @Id
    private  Long poNumber;
    private String poDate;
    private String poAddress;
    private int poLineNumber;
    private Long upcNumber;
    private  String upcName;
    private int orderedQuantity;
}