package com.promineotech.jewlery.service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.jewlery.dao.JewleryPurchaserDao;
import com.promineotech.jewlery.dao.JewlerySalesDao;
import com.promineotech.jewlery.entity.Jewlery;
import com.promineotech.jewlery.entity.JewleryModel;

import lombok.extern.slf4j.Slf4j;
//import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j


public class DefaultJewleryPurchaserService implements JewleryPurchaserService {

@Autowired
private JewleryPurchaserDao jewlerySalesDao;

@Transactional(readOnly = true)
	@Override
	 public List<Jewlery> fetchJewlery(JewleryModel design, String trim){

		   log.info("The jewleryModel method was called with arguments: (design= {}, piece=  {})", design , piece);

		   List<Jewlery> jewleries = JewleryPurchaserDao.fetchJewlery(design, piece);

		   if(jewleries.isEmpty()) {
			   String msg = String.format("No jewlery found with desing=%s and piece=%s", design, piece);
			   throw new NoSuchElementException(msg);
		   }

		   Collections.sort(jewleries);

		   return jewleries;
		  }
		}