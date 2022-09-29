package com.promineotech.jeep.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

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
  
  //@Autowired
  //private TestRestTemplate restTemplate;
  
 // @LocalServerPort
 // private int serverPort;

  @Test
  void testThatJeepsAreReturnedWhenAValidModelAndTrimAreSupplied() {

    JeepModel model = JeepModel.WRANGLER;
    String trim = "Sport";
    String uri = String.format("%s?model=%s&trim=%s", getBaseUri(), model, trim);

    ResponseEntity<List<Jeep>> response = restTemplate.exchange(uri,
    HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    List<Jeep> expected = buildExpected();
    assertThat(response.getBody()).isEqualTo(expected);
    
    // ResponseEntity<List<Jeep>> response = getRestTemplate.exchange(uri, 
   // 		HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
   // assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
   // List<Jeep> expected = buildExpected();
    
  //  ResponseEntity<Jeep> response = 
    //    getRestTemplate(). getForEntity(uri, Jeep.class);
   // assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    
   // List<Jeep> expected = buildExpected(); 
   // assertThat(response.getBody()).isEqualTo(expected); 
   
   
  }
  
  List<Jeep> buildExpected(){
	  List<Jeep> list = new LinkedList<>(); 
	  
	  list.add(Jeep.builder()
			  .modelId(JeepModel.WRANGLER)
			  .trimLevel("Freedom")
			  .numDoors(2)
			  .wheelSize(17)
			  .basePrice(new BigDecimal ("28474.00"))
			  .build()); 
	  
	  list.add(Jeep.builder().modelId(JeepModel.WRANGLER)
			  .trimLevel("Freedom")
			  .numDoors(4)
			  .wheelSize(17)
			  .basePrice(new BigDecimal ("31975.00"))
			  .build()); 
	  
	  return list; 
	  
  }

/**
 * @return
 */
//public TestRestTemplate getRestTemplate() {
	
//	return null
//}
}



		


