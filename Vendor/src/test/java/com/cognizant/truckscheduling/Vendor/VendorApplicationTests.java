package com.cognizant.truckscheduling.Vendor;


import com.cognizant.truckscheduling.Vendor.model.Vendor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class VendorApplicationTests {

    private String url = "http://localhost:8083/v1/vendor";
    private String urlId = "http://localhost:8083/v1/vendor/getVendorById/";
    RestTemplate template = new RestTemplate();

    @Test
    @Rollback(false)
    public void testSaveList() {
        template.delete(url);

        Vendor vendor = new Vendor();
        vendor.setVendorName("Madhu");
        vendor.setPhoneNumber(7036177542L);
        vendor.setVendorEmail("madhu@gmail.com");
        vendor.setVendorAddress("Visakhapatnam");
        ResponseEntity<Vendor> vendorCreated = template.postForEntity(url, vendor, Vendor.class);
        assertNotNull(vendorCreated);
    }

    @Test
    public void testGetVendorById() {
        int id = 1;
        Vendor vendor = template.getForObject(urlId + id, Vendor.class);
        assertNotNull(vendor);
    }

    @Test
    public void testGetVendorList() {
        ResponseEntity<Vendor[]> vendorList = template.getForEntity(url, Vendor[].class);
        List<Vendor> result = Arrays.asList(vendorList.getBody());
        for (Vendor vendor : result)
            System.out.println(vendor);
        assertThat(result).size().isGreaterThan(0);
    }

    @Test
    @Rollback(false)
    public void testUpdateVendor() {
        int id = 1;
        Vendor vendor = template.getForObject(urlId + id, Vendor.class);
//        Address address = new Address();
//        address.setVendorEmail("madhu@gmail.com");
//        address.setStreetName("Srinagar");
//        address.setCountry("India");
//        address.setCity("Visakhapatnam");
//        address.setState("Andhra Pradesh");
//        address.setZipCode(530011);
        vendor.setVendorName("Moulica");
//        vendor.setVendorEmail("madhu@gmail.com");
        vendor.setPhoneNumber(9966077601L);
//        vendor.setAddress(address);
        template.put(url + "/" + id, vendor);
//        assertThat(updated.getDcCity()).isEqualTo(dc2.getDcCity());
    }

    @Test
    @Rollback(false)
    public void testDeleteVendor() {
        int id = 1, c = 0;
        Vendor vendor = template.getForObject(urlId + id, Vendor.class);
        template.delete(url + "/" + id);
        c++;
        assertThat(c >= 1);
    }

}
