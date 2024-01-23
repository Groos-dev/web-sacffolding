package org.xinboot.framework.webscaffolding.message;

public interface GenericResultCode {
  boolean isSuccess();
  int getCode();
  String getMessage();
}
