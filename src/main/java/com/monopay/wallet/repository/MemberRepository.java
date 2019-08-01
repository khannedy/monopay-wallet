package com.monopay.wallet.repository;

import com.monopay.wallet.entity.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberRepository extends MongoRepository<Member, String> {

  Member findByIdAndMerchantId(String id, String merchantId);

}
