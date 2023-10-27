package com.olympus.platform.model;

import java.math.BigDecimal;
import java.util.List;
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
public class CmResumeGetResponseDTO {

  private String communityId;
  private String cmName;
  private byte[] cmPhoto;
  private BigDecimal cmStarts;
  private String cmInfo;
  private String cmFounder;
  private String cmDesc;
  private List<SocialPtInfoDTO> socialPlatforms;
  private String error;
}
