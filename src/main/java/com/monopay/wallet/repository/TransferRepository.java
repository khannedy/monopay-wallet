package com.monopay.wallet.repository;

import com.monopay.wallet.entity.Transfer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TransferRepository extends MongoRepository<Transfer, String> {

  List<Transfer> findAllByMemberIdAndMerchantIdOrderByCreatedAtDesc(String memberId, String merchantId);

}
