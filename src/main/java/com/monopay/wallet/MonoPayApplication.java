package com.monopay.wallet;

import com.monopay.wallet.properties.AuthenticationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
@EnableConfigurationProperties({
  AuthenticationProperties.class
})
public class MonoPayApplication {

  public static void main(String[] args) {
    SpringApplication.run(MonoPayApplication.class, args);
  }

}
