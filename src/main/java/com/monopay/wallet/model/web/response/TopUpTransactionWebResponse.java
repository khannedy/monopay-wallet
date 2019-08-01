package com.monopay.wallet.model.web.response;

import com.monopay.wallet.entity.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TopUpTransactionWebResponse {

  private String memberId;

  private Long beforeBalance;

  private Long afterBalance;

  private Long beforePoint;

  private Long afterPoint;

  private TransactionType type;

}
