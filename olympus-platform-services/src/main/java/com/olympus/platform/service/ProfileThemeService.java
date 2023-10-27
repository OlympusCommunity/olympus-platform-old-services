package com.olympus.platform.service;

import com.olympus.platform.model.ProfileThemePostRequestDTO;
import com.olympus.platform.model.ProfileThemePostResponseDTO;

public interface ProfileThemeService {

  ProfileThemePostResponseDTO createThemesForProfileService(
      ProfileThemePostRequestDTO profileThemePostRequestDTO, String porfileId);
}
