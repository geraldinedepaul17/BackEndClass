package com.promineotech.jewlery.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.jewlery.entity.Owner;
import com.promineotech.jewlery.service.AgentService;

import lombok.extern.slf4j.Slf4j;

@SuppressWarnings("hiding")
@RestController
@Slf4j
public abstract class DefaultAgentController<OwnerRequest> implements EstateController {

  private static final com.promineotech.jewlery.service.OwnerRequest AgentRequest = null;
@Autowired
  private AgentService AgentService;

  public Owner createOwner(OwnerRequest OwnerRequest) {
    log.info("Owner = {}",OwnerRequest);
    return AgentService.createOwner(AgentRequest);
  }
}