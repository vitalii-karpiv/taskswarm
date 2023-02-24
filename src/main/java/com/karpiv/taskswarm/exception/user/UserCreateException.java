package com.karpiv.taskswarm.exception.user;

import com.karpiv.taskswarm.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserCreateException extends BaseException {

  private static final String USE_CASE_PREFIX = BaseException.ERROR_PREFIX + "user/create/";

  public UserCreateException(Error error) {
    super(error.message, error.status, error.code);
  }

  public enum Error {
    INVALID_DTO_IN(USE_CASE_PREFIX + "invalidDtoIn", "Invalid dtoIn"),
    DAO_CREATE_FAILED(USE_CASE_PREFIX + "daoCreateFailed", "Create user object in database failed", 422);

    private final String code;
    private final String message;
    private int status = 400;


    Error(String code, String message) {
      this.code = code;
      this.message = message;
    }

    Error(String code, String message, int status) {
      this.code = code;
      this.message = message;
      this.status = status;
    }
  }

}
