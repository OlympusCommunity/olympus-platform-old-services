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
public class SocialPtInfoDTO {

  private Long socialPtId;
  private String socialPtDesc;
  private String socialPtLink;
  private SocialNetInfoDTO socialNetwork;
}
