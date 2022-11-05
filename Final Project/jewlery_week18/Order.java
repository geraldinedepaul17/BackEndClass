package com.promineotech.jewlery.entity;

import java.math.BigDecimal;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Jewlery {
  private Long jewleryPK;
  private Owner owner;
  private Jewlery design;
  private Stone stone;
  private Piece piece;
  private List<Agents> agent;
  private BigDecimal price;
  
  @JsonIgnore
  public Long getOwnerPK() {
    return ownerPK;
  }
}
