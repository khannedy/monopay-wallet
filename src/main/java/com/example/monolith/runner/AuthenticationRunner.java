package com.example.monolith.runner;

import com.example.monolith.entity.Authentication;
import com.example.monolith.entity.Merchant;
import com.example.monolith.repository.AuthenticationRepository;
import com.example.monolith.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationRunner implements ApplicationRunner {

  public static final String ADMIN_ID = "yourMerchantID";
  public static final String API_KEY = "SECRET";

  @Autowired
  private AuthenticationRepository authenticationRepository;

  @Autowired
  private MerchantRepository merchantRepository;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    if (!authenticationRepository.existsById(ADMIN_ID)) {
      authenticationRepository.save(Authentication.builder()
        .id(ADMIN_ID)
        .apiKey(API_KEY)
        .build());
    }

    if (!merchantRepository.existsById(ADMIN_ID)) {
      merchantRepository.save(Merchant.builder()
        .id(ADMIN_ID)
        .name("Your Merchant Name")
        .build());
    }
  }
}
