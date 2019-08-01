package com.monopay.wallet.repository;

import com.monopay.wallet.entity.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, String> {

  List<Transaction> findAllByBalanceIdAndMerchantIdOrderByCreatedAtDesc(String balanceId, String merchantId);

}
