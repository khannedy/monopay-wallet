package com.example.monolith.model.service;

import com.example.monolith.validation.MemberMustExists;
import com.example.monolith.validation.MerchantMustExists;
import com.example.monolith.validation.data.MemberData;
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
