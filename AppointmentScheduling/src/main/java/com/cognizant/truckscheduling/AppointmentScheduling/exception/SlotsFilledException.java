package com.cognizant.truckscheduling.AppointmentScheduling.exception;

public class SlotsFilledException extends Exception {
    private  String s;
    public SlotsFilledException(String message) {
        super(message);
        this.s=message;
    }
}
