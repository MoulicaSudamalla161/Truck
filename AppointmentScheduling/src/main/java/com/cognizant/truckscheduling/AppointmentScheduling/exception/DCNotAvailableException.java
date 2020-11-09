package com.cognizant.truckscheduling.AppointmentScheduling.exception;

public class DCNotAvailableException extends Exception {
    String message;
    public DCNotAvailableException(String s) {
        super(s);
        this.message=s;
    }
}
