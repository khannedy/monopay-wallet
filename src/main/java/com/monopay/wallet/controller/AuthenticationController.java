package com.monopay.wallet.controller;

import com.monopay.wallet.entity.Authentication;
import com.monopay.wallet.model.web.WebResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/auth")
@RestController
public class AuthenticationController {

  @PostMapping(value = "/authenticate", produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<String> authenticate(Authentication authentication) {
    return WebResponse.<String>builder()
      .code(HttpStatus.OK.value())
      .status(HttpStatus.OK.name())
      .build();
  }

}
