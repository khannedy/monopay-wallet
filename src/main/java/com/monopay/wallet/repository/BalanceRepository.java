package com.monopay.wallet.repository;

import com.monopay.wallet.entity.Balance;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BalanceRepository extends MongoRepository<Balance, String> {

}
