package com.example.monolith.repository;

import com.example.monolith.entity.Authentication;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthenticationRepository extends MongoRepository<Authentication, String> {

  Authentication findByApiKey(String apiKey);

}
