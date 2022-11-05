 package com.promineotech.jewlery.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.promineotech.jewlery.Agent;
import com.promineotech.jewlery.entity.Jewlery;
import com.promineotech.jewlery.entity.Owner;
import com.promineotech.jewlery.entity.Pieces;
import com.promineotech.jewlery.entity.Stones;

public interface AgentDao {
  List<Agent> fetchOwner(List<String> ownerIds);
  Optional<Owner> fetchOwner(String ownerId);
  Optional<Jewlery> fetchPieces( String piece, int design);
  Optional<Stones> fetchStone(String stoneId);
  Optional<Pieces> fetchPieces(String pieceId);

  Owner saveOwner(
		  Owner owner,
		  Jewlery jewlery,
		  Stones stone,
		  BigDecimal price,
		    List<Owner> owners);
/**
 * @param owner
 * @param jewlery
 * @param stone
 * @param price
 * @param options
 * @return
 */
Jewlery saveJewlery(Owner owner, Jewlery jewlery, Stone stone, BigDecimal price, List<Owner> options);

}