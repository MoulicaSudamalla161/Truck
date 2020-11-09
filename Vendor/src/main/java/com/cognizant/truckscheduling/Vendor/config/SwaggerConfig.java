package com.cognizant.truckscheduling.Vendor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("vendor-application")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cognizant.truckscheduling"))
                .build()
                .apiInfo(apiInfo());

    }
    List<VendorExtension> vendorExtensions = new ArrayList<>();
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Vendor Application","Customers can add, update, delete and search trucks.","1.0","",new Contact("Moulica","","abc@gmail.com"),"Apache License","\"http://www.apache.org/licenses/LICENSE-2.0\"", vendorExtensions);
    }
}
