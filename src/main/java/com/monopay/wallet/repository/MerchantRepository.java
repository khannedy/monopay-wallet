package com.monopay.wallet.repository;

import com.monopay.wallet.entity.Merchant;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MerchantRepository extends MongoRepository<Merchant, String> {

}
