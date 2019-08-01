package com.example.monolith;

import com.example.monolith.properties.AuthenticationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
@EnableConfigurationProperties({
  AuthenticationProperties.class
})
public class WorkshopMonolithApplication {

  public static void main(String[] args) {
    SpringApplication.run(WorkshopMonolithApplication.class, args);
  }

}
