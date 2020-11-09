package com.cognizant.truckscheduling.AppointmentScheduling.exception;

public class DCSlotNotFoundException extends Exception {
    String message;
    public DCSlotNotFoundException(String  s) {
        super(s);
        this.message=s;
    }
}
