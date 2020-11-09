package com.walmart.day1.springbasics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws ParseException {


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("Enter product details : ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter product id: ");
        Product product = context.getBean(Product.class) ;
         product.productId   =   sc.nextInt();
        System.out.println("Enter product name: ");
        product.productName=  sc.next();
        System.out.println("Enter product delivery date : ");
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        product.date= sc.next();
//        System.out.println(new SimpleDateFormat("MM-dd-yyyy").format(product.date));
        Date date=sdf.parse(product.date);
//        System.out.println(new SimpleDateFormat("MM-dd-yyyy").format(date));

        Date dateobj = new Date();
//        Date date1=sdf.parse(dateobj);
        ProductInfo productInfo = context.getBean(ProductInfo.class) ;
        if(date.after(dateobj))
            productInfo.setStatus("Delivered");
         else if(date.before(dateobj))
            productInfo.setStatus("Will be Delivered Soon");
          else
            productInfo.setStatus("Shipped");

         productInfo.display();


    }
}
