package com.monopay.wallet.repository;

import com.monopay.wallet.entity.Authentication;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthenticationRepository extends MongoRepository<Authentication, String> {

  Authentication findByApiKey(String apiKey);

}
