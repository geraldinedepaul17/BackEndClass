package com.promineotech.jewlery.entity;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JewleryOwner {
  private Long jewleryPK;
  private Owner owner;
  private Pieces piece;
  private Stones stone;
  private List<Owner> jewleryowner;
  private BigDecimal price;

  @JsonIgnore
  public Long getJweleryPK() {
    return jewleryPK;
  }
}
