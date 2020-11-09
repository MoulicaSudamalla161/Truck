package com.cognizant.kafkacloudstreamconsumer;

import com.cognizant.kafkacloudstreamconsumer.model.PoInformation;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class KafkaCloudStreamConsumerApplicationTests {

	private String url="http://localhost:8090/v1/poInformation";
	RestTemplate template = new RestTemplate();

	@Test
	@Rollback(false)
	public void createPoInformation(){
		PoInformation poInformation = new PoInformation();
		poInformation.setPoNumber(12345L);
		poInformation.setPoDate("31/10/2020");
		poInformation.setPoLineNumber(2);
		poInformation.setOrderedQuantity(2);
		poInformation.setPoAddress("Chennai");
		poInformation.setUpcNumber(9876543L);
		poInformation.setUpcName("Shoes");
		ResponseEntity<PoInformation> poCreated= template.postForEntity(url,poInformation, PoInformation.class) ;
		assertNotNull(poCreated);
	}

}
