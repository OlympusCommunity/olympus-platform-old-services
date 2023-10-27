package com.olympus.platform.service;

import com.olympus.platform.model.ProfileGetResponseDTO;
import com.olympus.platform.model.ProfilePostRequestDTO;
import com.olympus.platform.model.ProfilePostResponseDTO;
import com.olympus.platform.model.ProfilePutRequestDTO;
import com.olympus.platform.model.ProfilePutResponseDTO;

public interface ProfileService {

  ProfilePostResponseDTO createProfileService(ProfilePostRequestDTO profilePostRequestDTO);

  ProfileGetResponseDTO getProfileInformationService(String profileId, String userId);

  ProfilePutResponseDTO updateProfileInformationService(
      ProfilePutRequestDTO profilePutRequestDTO);
}
