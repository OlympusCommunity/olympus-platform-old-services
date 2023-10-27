package com.olympus.platform.service;

import com.olympus.platform.model.SocialPtPostRequestDTO;
import com.olympus.platform.model.SocialPtPostResponseDTO;
import java.util.List;

public interface SocialPaltformService {

  SocialPtPostResponseDTO createSocialPlatformToCommunity(
      List<SocialPtPostRequestDTO> socialRequestList, String profileId);
}
