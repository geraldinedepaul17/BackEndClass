package com.promineotech.jewlery.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.jewlery.entity.Jewlery;
import com.promineotech.jewlery.entity.Owner;
import com.promineotech.jewlery.entity.Pieces;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@OpenAPIDefinition(info = @Info(title = "Jewlery Agent Service"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server.")})

@RequestMapping("/jewlery")

public interface EstateController {

	  @Operation(
	      summary = "Create an order for a Jewlery",
	      description = "Retruns the created Jewlery",
	      responses = {
	          @ApiResponse(responseCode = "201",
	              description = "The created Jewlery is returned",
	              content = @Content(mediaType = "application/json",
	              schema = @Schema(implementation = Jewlery.class))),
	          @ApiResponse(responseCode = "400",
	            description = "The request parameters are invalid",
	            content = @Content(mediaType = "application/json")),
	          @ApiResponse(responseCode = "404",
	            description = "A Jeep component was not found with the input criteria",
	            content = @Content(mediaType = "application/json")),
	          @ApiResponse(responseCode = "500",
	            description = "An unplanned error occurred",
	            content = @Content(mediaType = "application/json"))
	      },
	      parameters = {
	          @Parameter(name = "orderRequest",
	            required = true,
	            description = "The order as JSON"),

	      }
	  )
	  @PostMapping
	  @ResponseStatus(code = HttpStatus.CREATED)
	  Owner createOwner(@RequestBody OwnerRequest ownerRequest);

	/**
	 * @param piece
	 * @param design
	 * @return
	 */
	List<Jewlery> fetchJewlery(Pieces piece, String design);
	}