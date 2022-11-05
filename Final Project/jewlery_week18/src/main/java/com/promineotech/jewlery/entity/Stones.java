package com.promineotech.jewlery.entity;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Stones {
  private Long stonePK;
  private String stoneId;
  private String stone;
  private BigDecimal price;
  private boolean isMultistone;
}
