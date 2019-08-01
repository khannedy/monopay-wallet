package com.monopay.wallet.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "members")
public class Member {

  @Id
  private String id;

  private String merchantId;

  private String name;

  private String email;

  private String phone;

  private Boolean verified;

  @Version
  private Long version;

  @CreatedDate
  private Long createdAt;

  @LastModifiedDate
  private Long lastModifiedAt;

}
