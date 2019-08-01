package com.monopay.wallet.controller;

import com.monopay.wallet.exception.AuthenticationException;
import com.monopay.wallet.model.web.WebResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class ExceptionController {

  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  @ExceptionHandler(AuthenticationException.class)
  public WebResponse<String> authenticationException(AuthenticationException e) {
    return WebResponse.<String>builder()
      .code(HttpStatus.UNAUTHORIZED.value())
      .status(HttpStatus.UNAUTHORIZED.name())
      .build();
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(ConstraintViolationException.class)
  public WebResponse<String> constraintViolationException(ConstraintViolationException e) {
    return WebResponse.<String>builder()
      .code(HttpStatus.BAD_REQUEST.value())
      .status(HttpStatus.BAD_REQUEST.name())
      .data(e.getMessage())
      .build();
  }

}
