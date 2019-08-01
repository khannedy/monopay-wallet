package com.example.monolith.model.web.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetMemberWebResponse {

  private String id;

  private String email;

  private String phone;

  private String name;

  private Balance balance;

  @Data
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Balance {

    private Long balance;

    private Long point;

  }

}
