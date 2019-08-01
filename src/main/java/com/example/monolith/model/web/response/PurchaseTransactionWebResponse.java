package com.example.monolith.model.web.response;

import com.example.monolith.entity.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseTransactionWebResponse {

  private String memberId;

  private Long beforeBalance;

  private Long afterBalance;

  private Long beforePoint;

  private Long afterPoint;

  private TransactionType type;

}
