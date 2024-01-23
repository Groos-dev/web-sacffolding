package org.xinboot.framework.webscaffolding.common.exception;

import lombok.Data;
import org.xinboot.framework.webscaffolding.common.message.ResultCode;

/**
 * @author zengxin
 */
@Data
public class BusinessException extends RuntimeException{
  private Integer code;

  public BusinessException(ResultCode resultCode){
    super(resultCode.getMessage());
    this.code = resultCode.getCode();
  }

  public BusinessException(ResultCode resultCode, String message){
    super(message);
    this.code = resultCode.getCode();
  }

}
