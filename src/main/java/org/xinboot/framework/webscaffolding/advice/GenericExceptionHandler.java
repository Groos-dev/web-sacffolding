package org.xinboot.framework.webscaffolding.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.xinboot.framework.webscaffolding.common.message.Result;
import org.xinboot.framework.webscaffolding.common.message.ResultCode;

@RestControllerAdvice
@Slf4j
public class GenericExceptionHandler {

  @ExceptionHandler(Exception.class)
  public Result<Object> exceptionHandler(Exception e){
    log.error("Handler Exception {}, {}", e.getMessage(), e.getStackTrace());
    return new Result<>( null,e.getMessage(), 500, false);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Result<Object> handleValidationExceptions(
      MethodArgumentNotValidException ex) {
    StringBuilder errors = new StringBuilder();
    ex.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.append(errorMessage);
      errors.append(",");
    });
    return new Result<>(null,
        errors.substring(0, errors.length()-1),
        ResultCode.ARGUMENT_NOT_VALID_ERROR.getCode(), false);
  }

}
