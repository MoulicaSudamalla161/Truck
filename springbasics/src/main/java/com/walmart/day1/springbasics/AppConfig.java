package com.walmart.day1.springbasics;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "com.walmart.day1.springbasics")
public class AppConfig {

    @Bean
    public Product product(){
        return new Product();
    }

    @Bean
    public  ProductInfo productInfo() {
        return new ProductInfo(product(),"");
    }


}
