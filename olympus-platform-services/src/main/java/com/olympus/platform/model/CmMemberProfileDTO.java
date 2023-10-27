package com.olympus.platform.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CmMemberProfileDTO {

  private String profileId;
  private String name;
  private String surname;
  private String nickname;
  private String alias;
  private byte[] photo;
  private String roleName;
}
