package com.example.monolith.model.web.response;

import com.example.monolith.entity.TransferStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransferWebResponse {

  private String id;

  private String memberId;

  private String bank;

  private String bankAccountName;

  private Long total;

  private TransferStatus status;

  private Long createdAt;
}
