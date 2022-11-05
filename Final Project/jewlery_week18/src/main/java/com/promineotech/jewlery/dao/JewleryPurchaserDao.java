package com.promineotech.jewlery.dao;

import java.util.List;

import com.promineotech.jewlery.entity.DesignStyle;
import com.promineotech.jewlery.entity.Jewlery;

public interface JewleryPurchaserDao {

	/**
	 * @param model
	 * @param trim
	 * @return
	 */
	List<Jewlery> fetchJewlery(DesignStyle design, String piece);

}
