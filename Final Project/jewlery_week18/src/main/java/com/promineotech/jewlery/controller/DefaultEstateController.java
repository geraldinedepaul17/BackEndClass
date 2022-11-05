package com.promineotech.jewlery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.jewlery.entity.Jewlery;
import com.promineotech.jewlery.entity.Owner;
import com.promineotech.jewlery.entity.Pieces;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j

public class DefaultEstateController implements EstateController {

	@Autowired
	private EstateService estateService;

	@Override
	public List<Jewlery> fetchJewlery(Pieces piece, String design) {
		log.info("Piece = {}, Design = {}", piece, design);

		return estateService.fetchJewlery(piece, design);

	}

	@Override
	public Owner createOwner(OwnerRequest ownerRequest) {

		return null;
	}

}