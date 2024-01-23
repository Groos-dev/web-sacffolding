package org.xinboot.framework.webscaffolding.model.response;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author zengxin
 */
@Data
public class GetBookResponse extends BaseResponse {

  private String name;

  private BigDecimal price;

  private String description;
}
