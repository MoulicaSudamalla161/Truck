package com.cognizant.truckscheduling.Vendor.exception;

public class VendorExistException extends Exception {
    private String message;
    public VendorExistException(String s) {
        super(s);
        this.message=s;
    }
}
