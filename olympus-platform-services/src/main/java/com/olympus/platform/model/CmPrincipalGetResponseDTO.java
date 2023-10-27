package com.olympus.platform.model;

import java.math.BigDecimal;
import java.util.Date;
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
public class CmPrincipalGetResponseDTO {

  private String communityId;
  private String cmName;
  private String cmDesc;
  private byte[] cmPhoto;
  private BigDecimal cmScore;
  private Long cmViews;
  private Date creationDate;

  private CmMemberProfileDTO founder;
  private List<ThemeCommunityDTO> themes;
  private Long numberOfTotalMembers;
  private List<SocialPtCommunityDTO> socialPlatforms;
}
