package com.cognizant.truckscheduling.exception;

public class SlotNotFoundException extends Exception {
    String message;
    public SlotNotFoundException(String s) {
        super(s);
        this.message=s;
    }
}
