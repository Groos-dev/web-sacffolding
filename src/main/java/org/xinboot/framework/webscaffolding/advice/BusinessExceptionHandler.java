package org.xinboot.framework.webscaffolding.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.xinboot.framework.webscaffolding.common.exception.BusinessException;
import org.xinboot.framework.webscaffolding.common.message.Result;

@RestControllerAdvice
@Slf4j
public class BusinessExceptionHandler {

  @ExceptionHandler(BusinessException.class)
  public Result<Object> exceptionHandler(BusinessException e){
    log.error("Handler QueryServiceBusinessException", e);
    return new Result<>( null,e.getMessage(), e.getCode(), false);
  }
}
