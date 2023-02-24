package com.karpiv.taskswarm.exception;

import com.karpiv.taskswarm.exception.user.UserCreateException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BaseExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(UserCreateException.class)
  public ResponseEntity<ErrorResponse> handleCustomException(UserCreateException ex) {
    ErrorResponse errorResponse = new ErrorResponse(ex.getStatus(), ex.getCode(), ex.getMessage(), ex.getCause(), ex.getParamMap());
    return new ResponseEntity<>(errorResponse, HttpStatusCode.valueOf(ex.getStatus()));
  }

}
