package com.olympus.platform.service;

import com.olympus.platform.model.CmPrincipalGetResponseDTO;
import com.olympus.platform.model.CmResumeGetResponseDTO;
import com.olympus.platform.model.CommunityPostRequestDTO;
import com.olympus.platform.model.CommunityPostResponseDTO;
import java.util.List;

public interface CommunityService {

  CommunityPostResponseDTO createCommunityInformationService(
      CommunityPostRequestDTO communityPostRequestDTO, String profileId);

  List<CmPrincipalGetResponseDTO> getCommunitiesForPrincipalPageService(String profileId);

  List<CmResumeGetResponseDTO> getCommunities(String proifleId, String userId);
}
