package com.cognizant.truckscheduling.AppointmentScheduling.exception;

public class VendorNotFoundException extends Exception {
     String message;

    public VendorNotFoundException(String s) {
        super(s);
        this.message=s;
    }
}
