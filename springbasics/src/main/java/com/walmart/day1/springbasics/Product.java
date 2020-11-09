package com.walmart.day1.springbasics;

import org.springframework.stereotype.Component;

public class Product {

   public int productId;
   public String productName;
    public String date;

    public Product() {

    }

    public Product(int productId, String productName, String date) {
        this.productId = productId;
        this.productName = productName;
        this.date = date;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
