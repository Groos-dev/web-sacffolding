package org.xinboot.framework.webscaffolding.common.message;

public enum ResultCode implements GenericResultCode {

  SUCCESS(0, true, null),
  FAIL(1000, false, "fail"),
  UNAUTHORIZED(3000, false, "unauthorized"),
  FORBIDDEN(3001, false, "forbidden"),
  LOGIN_REQUIRED(3002, false, "login required"),
  SESSION_EXPIRED(3003, false, "session expired"),
  BAD_REQUEST(4000, false, "bad request"),
  ILLEGAL_PARAMETER(4001, false, "illegal parameter"),
  UNAVAILABLE(4002, false, "unavailable"),
  CONFLICT(4003, false, "conflict"),
  EXPIRED(4004, false, "expired"),
  ERROR(5000, false, "error"),
  ARGUMENT_NOT_VALID_ERROR(5002, false,  "argument not valid error"),

  USER_NOT_FOUND(5001, false, "user not found"),

  PROJECT_NOT_FOUND(5002, false, "project not found"),
  FILE_NOT_FOUND(404, false, "file not found"),

  FOLDER_NOT_FOUND(7000, false, "folder not found"),
  PERMISSION_DENIED(8000, false, "permission denied"),

  QUERY_RESULT_NOT_FOUND(9000, false, "query result not found"),

  FAIL_TO_CHANGE_QUERY_STATUS(10000, false, "fail to change query status"),
  DATABASE_NOT_FOUND(11000, false, "database not found"),
  QUERY_INVALID(12000, false, "query invalid"),
  UNSUPPORTED_MEDIA_TYPE(13000, false, "unsupported media type"),
  SEND_EMAIL_SUCCESS(14000, false, "send email success"),

  // book
  BOOK_NOT_FOUND(15000, false, "book not found")
  ;

  private final int code;
  private final boolean success;
  private final String message;

  ResultCode(int code, boolean success, String message) {
    this.code = code;
    this.success = success;
    this.message = message;
  }

  public static ResultCode of(int code) {
    for (ResultCode resultCode : ResultCode.values()) {
      if (resultCode.getCode() == code) {
        return resultCode;
      }
    }
    return null;
  }

  @Override
  public boolean isSuccess() {
    return success;
  }

  @Override
  public int getCode() {
    return code;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
