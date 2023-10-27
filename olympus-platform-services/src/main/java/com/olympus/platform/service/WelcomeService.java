package com.olympus.platform.service;

import com.olympus.platform.model.WelcomeGetResponseDTO;
import com.olympus.platform.model.WelcomePostRequestDTO;
import com.olympus.platform.model.WelcomePostResponseDTO;
import com.olympus.platform.model.WelcomePutRequestDTO;
import com.olympus.platform.model.WelcomePutResponseDTO;

public interface WelcomeService {

  WelcomePostResponseDTO createWelcomMessageService(
      WelcomePostRequestDTO welcomePostRequestDTO);

  WelcomeGetResponseDTO getWelcomeMessageService();

  WelcomePutResponseDTO updateWelcomeMessageService(
      WelcomePutRequestDTO welcomePutRequestDTO);
}
