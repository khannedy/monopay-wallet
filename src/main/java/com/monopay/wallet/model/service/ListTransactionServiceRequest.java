package com.monopay.wallet.model.service;

import com.monopay.wallet.validation.MemberMustExists;
import com.monopay.wallet.validation.MerchantMustExists;
import com.monopay.wallet.validation.data.MemberData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@MemberMustExists(message = "MustExists")
public class ListTransactionServiceRequest implements MemberData {

  @NotBlank(message = "NotBlank")
  private String memberId;

  @NotBlank(message = "NotBlank")
  @MerchantMustExists(message = "MustExists")
  private String merchantId;
}
