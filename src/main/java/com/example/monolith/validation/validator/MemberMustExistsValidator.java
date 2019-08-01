package com.example.monolith.validation.validator;

import com.example.monolith.repository.MemberRepository;
import com.example.monolith.validation.MemberMustExists;
import com.example.monolith.validation.data.MemberData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MemberMustExistsValidator implements ConstraintValidator<MemberMustExists, MemberData> {

  @Autowired
  private MemberRepository memberRepository;

  @Override
  public boolean isValid(MemberData value, ConstraintValidatorContext context) {
    if (StringUtils.isEmpty(value.getMemberId()) || StringUtils.isEmpty(value.getMerchantId())) {
      return true;
    } else {
      return memberRepository.findByIdAndMerchantId(value.getMemberId(), value.getMerchantId()) != null;
    }
  }
}
