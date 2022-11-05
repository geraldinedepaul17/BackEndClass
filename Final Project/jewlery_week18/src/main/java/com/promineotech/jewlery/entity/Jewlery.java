/**
 *
 */
package com.promineotech.jewlery.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author gerriciancanelli
 *
 */




 public class Jewlery implements Comparable<Pieces> {
  private Long designPK;
  private JewleryModel pieceId;
  private String designStvle;
  private int numPieces;
  private BigDecimal basePrice;

  @JsonIgnore

  public Long getModelPK() {
	  return designPK;
  }

}