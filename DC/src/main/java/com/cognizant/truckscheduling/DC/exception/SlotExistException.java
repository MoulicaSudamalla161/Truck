package com.cognizant.truckscheduling.DC.exception;

public class SlotExistException extends Throwable {
    private  String message;

    public SlotExistException(String s) {
        super(s);
        this.message=s;
    }
}
