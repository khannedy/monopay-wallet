package com.example.monolith.repository;

import com.example.monolith.entity.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberRepository extends MongoRepository<Member, String> {

  Member findByIdAndMerchantId(String id, String merchantId);

}
