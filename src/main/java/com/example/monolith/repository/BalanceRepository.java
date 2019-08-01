package com.example.monolith.repository;

import com.example.monolith.entity.Balance;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BalanceRepository extends MongoRepository<Balance, String> {

}
