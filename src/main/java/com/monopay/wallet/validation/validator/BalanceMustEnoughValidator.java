package com.monopay.wallet.validation.validator;

import com.monopay.wallet.entity.Balance;
import com.monopay.wallet.repository.BalanceRepository;
import com.monopay.wallet.validation.BalanceMustEnough;
import com.monopay.wallet.validation.data.BalanceData;
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
