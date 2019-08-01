package com.example.monolith.model.service;

import com.example.monolith.validation.MemberMustExists;
import com.example.monolith.validation.MerchantMustExists;
import com.example.monolith.validation.data.MemberData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@MemberMustExists(message = "MustExists")
public class TopUpTransactionServiceRequest implements MemberData {

  @NotBlank(message = "NotBlank")
  private String memberId;

  @NotBlank(message = "NotBlank")
  @MerchantMustExists(message = "MustExists")
  private String merchantId;

  @NotNull(message = "NotNull")
  @Min(message = "TooSmall", value = 1L)
  @Max(message = "TooLarge", value = 1_000_000L)
  private Long total;

}
