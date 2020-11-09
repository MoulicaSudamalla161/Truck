package com.cognizant.truckscheduling.AppointmentScheduling.exception;

public class PONotFoundException extends  Exception {
String message;

    public PONotFoundException(String s) {
        super(s);
        this.message=s;
    }
}
