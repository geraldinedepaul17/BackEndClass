package com.promineotech.jewlery.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Owner {
  private Long ownerPK;
  private String ownerId;
  private String firstName;
  private String lastName;
  private String phone;
}
