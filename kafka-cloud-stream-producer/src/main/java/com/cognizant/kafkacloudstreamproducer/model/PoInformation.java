package com.cognizant.kafkacloudstreamproducer.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PoInformation {
    private  Long poNumber;
    private String poDate;
    private String poAddress;
    private int poLineNumber;
    private Long upcNumber;
    private  String upcName;
    private int orderedQuantity;

}