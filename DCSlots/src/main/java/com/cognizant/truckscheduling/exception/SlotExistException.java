package com.cognizant.truckscheduling.exception;

public class SlotExistException extends Exception {
    private String message;
    public SlotExistException(String slotMessage) {
        super(slotMessage);
        this.message=slotMessage;
    }
}
