package com.cognizant.truckscheduling.model;


import lombok.Data;

import java.time.LocalTime;


@Data
public class TimeSlots {

     private int hours;
     private  int minutes;

     public static String  dcSlotsMethod(int hours, int minutes){
     LocalTime initialTime= LocalTime.of(hours,minutes);
     LocalTime t2= LocalTime.of(1,0);
     LocalTime finalTime= t2.plusHours(hours).plusMinutes(minutes);
     String initialTime1 = initialTime.toString();
     String finalTime2 = finalTime.toString();
     String time= initialTime1.concat("-").concat(finalTime2);
     return  time;
     
 }
       

}
