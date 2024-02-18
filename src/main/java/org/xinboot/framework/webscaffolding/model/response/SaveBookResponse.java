package org.xinboot.framework.webscaffolding.model.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SaveBookResponse extends BaseResponse{
  private String name;

  private BigDecimal price;

  private String description;
}
