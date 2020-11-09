package com.cognizant.truckscheduling.Truck.exception;

public class TruckAleadyExistException extends Exception {
    private String message;

    public TruckAleadyExistException(String s) {
        super(s);
        this.message = s;
    }
}
