package org.xinboot.framework.webscaffolding.model.entity.auth;

import lombok.Data;

import java.util.UUID;

@Data
public class User {
  private UUID id;

  private String name;
}
