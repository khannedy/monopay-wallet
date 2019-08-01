package com.monopay.wallet.model.web.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TopUpTransactionWebRequest {

  private String memberId;

  private Long total;

}
