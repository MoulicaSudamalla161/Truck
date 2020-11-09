package com.cognizant.truckscheduling.Truck;

import com.cognizant.truckscheduling.Truck.model.Truck;
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
class TruckApplicationTests {
    String url = "http://localhost:8084/v1/truck";
    String urlId = "http://localhost:8084/v1/truck/getTruckById/";
    RestTemplate template = new RestTemplate();

    @Test
    @Rollback(false)
    public void testCreateTruck() {
        template.delete(url);
        Truck truck = new Truck();
        truck.setTruckNumber(123456L);
        truck.setTruckName("Poongodi");
        truck.setTruckType("abc");
        ResponseEntity<Truck> finalTruck = template.postForEntity(url, truck, Truck.class);
        assertNotNull(finalTruck);
    }

    @Test
    public void testGetTruckById() {
        int id = 1;
        Truck truck = template.getForObject(urlId + id, Truck.class);
        System.out.println(truck);
        assertEquals(truck.getTruckId(), id);
    }

    @Test
    public void testGetTruckList() {
        ResponseEntity<Truck[]> dcSlotsList = template.getForEntity(url, Truck[].class);
        List<Truck> result = Arrays.asList(dcSlotsList.getBody());
        for (Truck truck : result)
            System.out.println(truck);
        assertThat(result).size().isGreaterThan(0);
    }

    @Test
    @Rollback(false)
    public void testUpdateTruck() {
        int id = 1;
        Truck truck = template.getForObject(urlId + id, Truck.class);
        truck.setTruckNumber(9876L);
        truck.setTruckName("XYZ");
        truck.setTruckType("ABC");
        template.put(url + "/" + id, truck);

    }

    @Test
    @Rollback(false)
    public void testDeleteTruck() {
        int id = 1, c = 0;
        Truck truck = template.getForObject(urlId + id, Truck.class);
        template.delete(url + "/" + id);
        c++;
        assertThat(c >= 1);
    }
}
