package com.cognizant.truckscheduling.AppointmentScheduling.exception;

public class TruckNotFoundException extends Exception {
    String s;
    public TruckNotFoundException(String message) {
        super(message);
        this.s=message;
    }
}
