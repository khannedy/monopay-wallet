package com.example.monolith.validation.validator;

import com.example.monolith.entity.Balance;
import com.example.monolith.repository.BalanceRepository;
import com.example.monolith.validation.BalanceMustEnough;
import com.example.monolith.validation.data.BalanceData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BalanceMustEnoughValidator implements ConstraintValidator<BalanceMustEnough, BalanceData> {

  @Autowired
  private BalanceRepository balanceRepository;

  private BalanceMustEnough annotation;

  @Override
  public void initialize(BalanceMustEnough constraintAnnotation) {
    this.annotation = constraintAnnotation;
  }

  @Override
  public boolean isValid(BalanceData value, ConstraintValidatorContext context) {
    if (StringUtils.isEmpty(value.getMemberId()) || value.getTotal() == null) {
      return true;
    } else if (!balanceRepository.existsById(value.getMemberId())) {
      return true;
    } else {
      Balance balance = balanceRepository.findById(value.getMemberId()).get();
      if (annotation.withPoint()) {
        return (balance.getBalance() + balance.getPoint()) >= value.getTotal();
      } else {
        return balance.getBalance() >= value.getTotal();
      }
    }
  }
}
