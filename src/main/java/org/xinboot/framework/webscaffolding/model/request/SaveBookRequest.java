package org.xinboot.framework.webscaffolding.model.request;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author zengxin
 */

@Data
public class SaveBookRequest {

  private String name;

  private BigDecimal price;

  private String description;
}
