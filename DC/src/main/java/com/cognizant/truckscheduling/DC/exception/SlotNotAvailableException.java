package com.cognizant.truckscheduling.DC.exception;

public class SlotNotAvailableException extends Exception {
    private  String message;

    public SlotNotAvailableException(String s) {
        super(s);
        this.message=s;
    }
}
