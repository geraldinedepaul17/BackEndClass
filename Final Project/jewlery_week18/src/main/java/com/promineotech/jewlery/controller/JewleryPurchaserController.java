package com.promineotech.jewlery.controller;


import java.util.List;

import javax.validation.constraints.Pattern;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.jewlery.entity.Jewlery;
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
@RequestMapping("/jewlery")
@OpenAPIDefinition(info = @Info(title = "Jewlery Purchaser Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})


public interface JewleryPurchaserController {

  @Operation(
      summary = "Returns a list of Jewlery",
      description = "Returns a list of Jewlery given an optional piece and/or design.",
      responses = {
          @ApiResponse(responseCode = "200",
              description = "A list of Jewlery is returned",
              content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = Jewlery.class))),
          @ApiResponse(responseCode = "400",
            description = "The request parameters are invalid",
            content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404",
            description = "No Jeeps were found with the input criteria",
            content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500",
            description = "An unplanned error occurred",
            content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(name = "piece",
            allowEmptyValue = false,
            required = false,
            description = "The piece name (i.e., 'NECKLACE')"),
          @Parameter(name = "trim",
            allowEmptyValue = false,
            required = false,
            description = "The trim level (i.e., 'Italian')")
      }
  )

  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Jewlery> fetchJewlery(

      @RequestParam (required = false)
      		Pieces piece,
        //	@Length(max = 30)
      		@Pattern(regexp = "[\\w\\s]*")
      		@RequestParam (required = false)
      		String design);
}

