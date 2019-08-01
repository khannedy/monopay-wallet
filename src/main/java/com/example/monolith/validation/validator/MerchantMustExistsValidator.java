package com.example.monolith.validation.validator;

import com.example.monolith.repository.MerchantRepository;
import com.example.monolith.validation.MerchantMustExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MerchantMustExistsValidator implements ConstraintValidator<MerchantMustExists, String> {

  @Autowired
  private MerchantRepository merchantRepository;

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (StringUtils.isEmpty(value)) {
      return true;
    } else {
      return merchantRepository.existsById(value);
    }
  }
}
