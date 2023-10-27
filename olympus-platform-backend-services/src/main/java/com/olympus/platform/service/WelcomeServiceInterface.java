package com.olympus.platform.service;

import com.olympus.platform.model.welcome.*;

public interface WelcomeServiceInterface {

    WelcomePostResponseDTO createWelcomeMessageService(
            WelcomePostRequestDTO welcomePostRequestDTO);

    WelcomeGetResponseDTO getWelcomeMessageService();

    WelcomePutResponseDTO updateWelcomeMessageService(
            WelcomePutRequestDTO welcomePutRequestDTO);

}
