package com.cognizant.truckscheduling;

import com.cognizant.truckscheduling.model.DC;
import com.cognizant.truckscheduling.model.DCSlots;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DcSlotsApplicationTests {
    String url = "http://localhost:8082/v1/dcSlots";
	String urlId = "http://localhost:8082/v1/dcSlots/";
	RestTemplate template = new RestTemplate();

    @Test
	@Rollback(false)
	public void testCreateSlot(){
        template.delete(url);
		DCSlots dcSlots = new DCSlots();
		DC dc = new DC();
//		dcSlots.setId(1);
        dcSlots.setMaxTrucks(2);
		dcSlots.setTimeSlots("7");
        dc.setDcNumber(101);
		dcSlots.setDc(dc);
		ResponseEntity<DCSlots> finalDcSlots = template.postForEntity(url,dcSlots, DCSlots.class) ;
//		dcSlots.setId(dcSlots.getId());
		assertNotNull(finalDcSlots);
	}

	@Test
	public void testGetDCSlotById() {
        int id=8;
        DCSlots dcSlots =template.getForObject(urlId+id,DCSlots.class);
//		System.out.println(dcSlots);
		assertNotNull(dcSlots);
//		assertEquals(dcSlots.getId(),id);
	}

	@Test
	public void testGetDCSlot(){
		ResponseEntity<DCSlots[]> dcSlotsList= template.getForEntity(url,DCSlots[].class);
		List<DCSlots> result= Arrays.asList(dcSlotsList.getBody());
		for (DCSlots dc: result)
//			System.out.println(dc);
		assertThat(result).size().isGreaterThan(0);
	}

	@Test
	@Rollback(false)
	public void testUpdateDCSlot() {
      int id=1;
       DC dc = new DC();
       dc.setDcNumber(105);
      DCSlots dcSlots = template.getForObject(urlId+id,DCSlots.class);
      dcSlots.setMaxTrucks(3);
      dcSlots.setTimeSlots("9");
      dcSlots.setDc(dc);
      template.put(url+"/"+id,dcSlots);

	}

	@Test
	@Rollback(false)
	public void testDeleteDCSlot() {
		int id = 1, c = 0;
		DCSlots dcSlots = template.getForObject(urlId+id, DCSlots.class);
		template.delete(url + "/" + id);
		c++;
		assertThat(c >= 1);
	}
}
