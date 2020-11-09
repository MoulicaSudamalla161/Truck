package com.walmart.day1.springbasics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class ProductInfo {

    Product product;
    private String status;

    public ProductInfo() {
    }

    public ProductInfo(Product product,String status) {
        this.product = product;
        this.status = status;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public  void display(){
        System.out.println("Product Details: ");
        System.out.println("Product Id: " +product.productId);
        System.out.println("Product Name: " +product.productName);
        System.out.println("Product Delivery Date: " +product.date);
        System.out.println("Product Status: "+status);
    }
}
