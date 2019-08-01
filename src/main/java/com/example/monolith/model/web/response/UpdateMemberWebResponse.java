package com.example.monolith.model.web.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMemberWebResponse {

  private String id;

  private String email;

  private String phone;

  private String name;

}
