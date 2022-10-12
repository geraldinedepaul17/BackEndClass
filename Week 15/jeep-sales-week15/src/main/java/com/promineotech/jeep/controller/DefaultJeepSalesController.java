package com.promineotech.jeep.controller;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.jeep.dao.JeepSalesDao;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;
import com.promineotech.jeep.service.JeepSalesService;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

//import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j 

public class DefaultJeepSalesController implements JeepSalesController {

	 @Autowired
	  private JeepSalesService jeepSalesService;
	
  @Override
  public List<Jeep> fetchJeeps(JeepModel model, String trim) {
	log.info("Model = {}, Trim = {}", model, trim);

return jeepSalesService.fetchJeeps(model, trim);
	 
	//List<Jeep> jeeps = jeepSalesService.fetchJeeps(model, trim);
 	//List<Jeep> jeeps = jeepSalesDao.fetchJeeps(model, trim); 
	
	//Collections.sort(jeeps); 
	//return jeeps; 
  }



}