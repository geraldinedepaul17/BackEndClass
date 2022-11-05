package com.promineotech.jewlery.service;

import java.util.List;

import com.promineotech.jewlery.entity.Jewlery;
import com.promineotech.jewlery.entity.JewleryModel;

public interface JewleryPurchaserService {

	List<Jewlery> fetchJewlery(JewleryModel design, String piece);

	}
