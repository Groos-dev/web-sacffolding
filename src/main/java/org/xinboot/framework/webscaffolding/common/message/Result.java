package org.xinboot.framework.webscaffolding.common.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zengxin
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
  private T data;

  private String message;
  private Integer code;

  private boolean success;



}