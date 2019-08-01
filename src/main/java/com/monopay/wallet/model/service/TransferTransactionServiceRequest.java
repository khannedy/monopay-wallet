package com.monopay.wallet.model.service;

import com.monopay.wallet.validation.BalanceMustEnough;
import com.monopay.wallet.validation.MemberMustExists;
import com.monopay.wallet.validation.MerchantMustExists;
import com.monopay.wallet.validation.data.BalanceData;
import com.monopay.wallet.validation.data.MemberData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@MemberMustExists(message = "MustExists")
@BalanceMustEnough(message = "MustEnough", withPoint = false)
public class TransferTransactionServiceRequest implements MemberData, BalanceData {

  @NotBlank(message = "NotBlank")
  private String memberId;

  @NotBlank(message = "NotBlank")
  @MerchantMustExists(message = "MustExists")
  private String merchantId;

  @NotBlank(message = "NotBlank")
  private String bank;

  @NotBlank(message = "NotBlank")
  private String bankAccountNumber;

  @NotNull(message = "NotNull")
  @Min(message = "TooSmall", value = 10_000L)
  private Long total;

}
