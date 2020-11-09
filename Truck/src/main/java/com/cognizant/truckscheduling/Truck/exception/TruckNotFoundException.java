package com.cognizant.truckscheduling.Truck.exception;

public class TruckNotFoundException extends Exception {
    String message;

    public TruckNotFoundException(String s) {
        super(s);
        this.message = s;
    }
}
