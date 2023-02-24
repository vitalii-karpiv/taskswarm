package com.karpiv.taskswarm.exception;

import lombok.Getter;

import java.util.Map;

public class BaseException extends RuntimeException {
  public static final String ERROR_PREFIX = "taskswarm/";

  @Getter
  private final Integer status;
  @Getter
  private final String code;
  @Getter
  private transient Map<String, Object> paramMap;

  public BaseException(String message, int status, String code) {
    super(message);
    this.status = status;
    this.code = code;
  }

  public BaseException(String message, Throwable cause, int status, String code) {
    super(message, cause);
    this.status = status;
    this.code = code;
  }

  public BaseException(String message, int status, String code, Map<String, Object> paramMap) {
    super(message);
    this.status = status;
    this.code = code;
    this.paramMap = paramMap;
  }

  public BaseException(String message, Throwable cause, int status, String code, Map<String, Object> paramMap) {
    super(message, cause);
    this.status = status;
    this.code = code;
    this.paramMap = paramMap;
  }
}