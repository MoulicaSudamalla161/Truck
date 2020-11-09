package com.cognizant.truckscheduling.Vendor.exception;

public class VendorNotFoundException extends Exception {
    private String message;
    public VendorNotFoundException(String s) {
        super(s);
        this.message=s;
    }
}
