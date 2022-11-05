package com.promineotech.jewlery.entity;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pieces {
  private Long piecePK;
  private String pieceId;
  private String design_style;
  private int num_pieces;
  private int item_size;
  private BigDecimal price;
/**
 * @param string
 * @return
 */
public static Object valueOf(String string) {
	// TODO Auto-generated method stub
	return null;
}
}
