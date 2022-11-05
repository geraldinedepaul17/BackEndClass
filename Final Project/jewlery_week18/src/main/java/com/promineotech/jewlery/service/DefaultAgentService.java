package com.promineotech.jewlery.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.jewlery.dao.AgentDao;
import com.promineotech.jewlery.entity.Jewlery;
import com.promineotech.jewlery.entity.JewleryOwner;
import com.promineotech.jewlery.entity.Owner;
import com.promineotech.jewlery.entity.Pieces;
import com.promineotech.jewlery.entity.Stones;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultAgentService implements AgentService {

  @Autowired
  private AgentDao AgentDao;

  @Override
@Transactional
  public Owner createOwner(OwnerRequest ownerRequest) {
    log.info("Owner = {}",ownerRequest);

    Owner owner = getOwner1(ownerRequest);
    Jewlery jewlery = getPiece(ownerRequest);
    Stones stone = getStone(ownerRequest);
    List<Owner> owners = getOwner1(ownerRequest);

    BigDecimal price =
        jewlery.getBasePrice()
        .add(stone.getPrice());

    for(JewleryOwner owner1 : owner) {
      price = price.add(owner1.getPrice());
    }

    return AgentDao.saveOwner(owner, jewlery, stone, price, owners);
  }

  /**
   *
   * @param ownerRequest
   * @return
   */
  private List<Owner> getOwner1(OwnerRequest ownerRequest) {
    return AgentDao.fetchOwners(ownerRequest.getOwners());
  }


  /**
   *
   * @param ownerRequest
   * @return
   */
  private Stones getStone(OwnerRequest ownerRequest) {
    return AgentDao.fetchStone(ownerRequest.getStone())
        .orElseThrow(() -> new NoSuchElementException(
            "Stone with ID=" + ownerRequest.getStone() + " was not found"));
  }

  /**
   *
   * @param ownerRequest
   * @return
   */
  private Pieces getPiece(OwnerRequest ownerRequest) {
    return AgentDao
        .fetchPiece(ownerRequest.getPiece(), ownerRequest.getpiece(),
            ownerRequest.getDesign())
        .orElseThrow(() -> new NoSuchElementException("Piece with ID="
            + ownerRequest.getPiece() + ", piece=" + ownerRequest.getPiece()
            + ownerRequest.getDesign() + " was not found"));
  }

  /**
   *
   * @param ownerRequest
   * @return
   */
  private Owner getOwner(OwnerRequest ownerRequest) {
    return AgentDao.fetchOwner(ownerRequest.getOwner())
        .orElseThrow(() -> new NoSuchElementException("Owner with ID="
            + orderRequest.getOwner() + " was not found"));
  }
}