package com.example.monolith.model.service;

import com.example.monolith.validation.MemberMustExists;
import com.example.monolith.validation.MerchantMustExists;
import com.example.monolith.validation.data.MemberData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@MemberMustExists(message = "MustExists")
public class UpdateMemberServiceRequest implements MemberData {

  @NotBlank(message = "NotBlank")
  private String memberId;

  @MerchantMustExists(message = "MustExists")
  @NotBlank(message = "NotBlank")
  private String merchantId;

  @NotBlank(message = "NotBlank")
  private String name;

  @NotNull(message = "NotNull")
  private Boolean verified;
}
