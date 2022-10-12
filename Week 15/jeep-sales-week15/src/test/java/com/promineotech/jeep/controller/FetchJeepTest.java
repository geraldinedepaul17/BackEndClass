package com.promineotech.jeep.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.web.client.RestTemplate;

import com.promineotech.jeep.controller.support.BaseTest;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(scripts = {
    "classpath:flyway/migrations/V1.0__Jeep_Schema.sql",
    "classpath:flyway/migrations/V1.1__Jeep_Data.sql"}, 
    config = @SqlConfig(encoding = "utf-8"))

class FetchJeepTest extends BaseTest { 
  
  @Autowired
  private TestRestTemplate restTemplate;
  
  @LocalServerPort
  private int serverPort;

  @Test
  void testThatJeepsAreReturnedWhenAValidModelAndTrimAreSupplied() {

    JeepModel model = JeepModel.WRANGLER;
    String trim = "Sport";
    String uri = 
    		String.format("%s?model=%s&trim=%s", getBaseUri(), model, trim);

    ResponseEntity<List<Jeep>> response = 
    		restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
    
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    
   List<Jeep> actual = response.getBody(); 
    List<Jeep> expected = buildExpected();
    
  // Line 64 not in video:  
   actual.forEach(jeep -> jeep.setModelPK(null));
    
    assertThat(response.getBody()).isEqualTo(expected);
  }
  
    
  

    
  List<Jeep> buildExpected(){
	  List<Jeep> list = new LinkedList<>(); 
	  
	  list.add(Jeep.builder()
			  .modelId(JeepModel.WRANGLER)
			  .trimLevel("Sport")
			  .numDoors(2)
			  .wheelSize(17)
			  .basePrice(new BigDecimal ("28475.00"))
			  .build()); 
	  
	  list.add(Jeep.builder().modelId(JeepModel.WRANGLER)
			  .trimLevel("Sport")
			  .numDoors(4)
			  .wheelSize(17)
			  .basePrice(new BigDecimal ("31975.00"))
			  .build()); 
	  
	  Collections.sort(list);
	  return list; 
	
	  /* 
	  @Test
	    void testThatAnErrorMessageIsReturnedWhenAnInvalidTrimIsSupplied() {

	      JeepModel model = JeepModel.WRANGLER;
	      String trim = "Invalid Value";
	      String uri = 
	      		String.format("%s?model=%s&trim=%s", getBaseUri(), model, trim);

	      ResponseEntity<List<Jeep>> response = 
	    		  restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
	      
	      //Then: a not found (404) status code is returned 
	      assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	      // And: an error message is returned
	    
	    // ResponseEntity<List<Jeep>> response = getRestTemplate.exchange(uri, 
	   // 		HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
	   // assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	   // List<Jeep> expected = buildExpected();
	    
	  //  ResponseEntity<Jeep> response = 
	    //    getRestTemplate(). getForEntity(uri, Jeep.class);
	   // assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	  
	    List<Jeep> expected = buildExpected(); 
	    assertThat(response.getBody()).isEqualTo(expected); 
	}
	   Map<String, Object> error = response.getBody(); 
	   
	   //@formatter:off
	   assertThat(error)
	   .containsKey("message")
	   .containsEntry("status code", HttpStatus.NOT_FOUND.value())
	   .containsEntry("uri", "/jeeps")
	   .containsKey("timestamp")
	   .containsEntry("reason", HttpStatus.NOT_FOUND.getReasonPhrase());
	   //@formatter:on
	     */
	  
  }

/**
 * @return
 */
//public TestRestTemplate getRestTemplate() {
	
//	return null
//}
}



		





		


