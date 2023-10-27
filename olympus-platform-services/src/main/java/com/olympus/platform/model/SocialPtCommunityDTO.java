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
public class SocialPtCommunityDTO {

  private SocialNetworkCommunityDTO socialNetwork;
  private Long socialPtId;
  private String socialPtLink;
  private Long socialPtView;
}
