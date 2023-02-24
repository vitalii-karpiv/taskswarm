package com.karpiv.taskswarm.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
  private int status;
  private String code;
  private String message;
  private Throwable cause;
  private Map<String, Object> paramMap = new HashMap<>();

  public ErrorResponse(int status, String code, String message) {
    this.status = status;
    this.code = code;
    this.message = message;
  }

  public ErrorResponse(int status, String code, String message, Throwable cause) {
    this.status = status;
    this.code = code;
    this.message = message;
    this.cause = cause;
  }

  public ErrorResponse(int status, String code, String message, Map<String, Object> paramMap) {
    this.status = status;
    this.code = code;
    this.message = message;
    this.paramMap = paramMap;
  }
}
