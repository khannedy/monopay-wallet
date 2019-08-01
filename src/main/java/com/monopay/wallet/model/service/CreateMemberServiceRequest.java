package com.monopay.wallet.model.service;

import com.monopay.wallet.validation.MerchantMustExists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateMemberServiceRequest {

  @MerchantMustExists(message = "MustExists")
  @NotBlank(message = "NotBlank")
  private String merchantId;

  @Email(message = "MustValid")
  @NotBlank(message = "NotBlank")
  private String email;

  @Pattern(regexp = "[0-9]+", message = "MustValid")
  @NotBlank(message = "NotBlank")
  private String phone;

  @NotBlank(message = "NotBlank")
  private String name;
}
