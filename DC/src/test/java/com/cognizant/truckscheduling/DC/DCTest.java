package com.cognizant.truckscheduling.DC;

import com.cognizant.truckscheduling.DC.model.DC;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DCTest {

   private String url="http://localhost:8081/v1/DC";
   private String urlId = "http://localhost:8081/v1/DC/";
    RestTemplate template =new RestTemplate();

    @Test
    @Rollback(false)
    public void testSaveList(){
     template.delete(url);
     DC dc = new DC();
     dc.setDcNumber(101);
     dc.setDcCity("Chennai");
     dc.setDcType("Imports");
     ResponseEntity<DC> dc1= template.postForEntity(url,dc, DC.class) ;
     assertNotNull(dc1);
 }

  @Test
  public void  testGetDCById() {
     int id = 101;
     DC dc1 = template.getForObject(urlId+id,DC.class);
     assertEquals(dc1.getDcNumber(),id);
  }

    @Test
    @Rollback(false)
    public void testUpdateDc(){
      int dcNumber= 101;
        DC dc1 = template.getForObject(urlId+dcNumber,DC.class);
        dc1.setDcCity("Chennai");
        dc1.setDcType("Regional");
         template.put(url+"/"+dcNumber,dc1);
//         assertNotNull(template);
//        assertThat(updated.getDcCity()).isEqualTo(dc2.getDcCity());
    }

    @Test
    public void testListDc() {
        ResponseEntity<DC[]> dcList= template.getForEntity(url,DC[].class);
        List<DC> result= Arrays.asList(dcList.getBody());
      for (DC dc: result)
          System.out.println(dc);
      assertThat(result).size().isGreaterThan(0);
    }

    @Test
    @Rollback(false)
    public void testDeleteDC() {
      int id= 101,c=0;
      DC dc1= template.getForObject(urlId+id,DC.class);
//      dc1.
      template.delete(url+"/"+id);
      c++;
//      assertNull(template);
//      assertThat(c>0);
//      boolean isExist = repository.findById(id).isPresent();
//      repository.deleteById(id);
//       boolean notExist = repository.findById(id).isPresent();
//        assertTrue(isExist);
//        assertFalse(notExist);


    }

}
