package org.xinboot.framework.webscaffolding.common.message;

public interface GenericResultCode {
  boolean isSuccess();
  int getCode();
  String getMessage();
}
