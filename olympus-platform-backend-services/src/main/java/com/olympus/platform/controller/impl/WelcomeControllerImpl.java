package com.olympus.platform.controller.impl;

import com.olympus.platform.controller.WelcomeController;
import com.olympus.platform.model.welcome.*;
import com.olympus.platform.service.WelcomeServiceInterface;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@AllArgsConstructor
public class WelcomeControllerImpl implements WelcomeController {

    private WelcomeServiceInterface welcomeServiceInterface;
    @Autowired
    private final DaoAuthenticationProvider daoAuthenticationProvider;

    /**
     * Create Welcome Message
     *
     * @param welcomePostRequestDTO
     * @return WelcomeGetResponseDTO
     */
    @Override
    public ResponseEntity<WelcomePostResponseDTO> createWelcomeMessageController(WelcomePostRequestDTO welcomePostRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(welcomeServiceInterface.createWelcomeMessageService(welcomePostRequestDTO));
    }

    /**
     * Get Welcome Message
     *
     * @return WelcomeGetResponseDTO
     */
    @Override
    public ResponseEntity<WelcomeGetResponseDTO> getWelcomeMessageController() {
        return ResponseEntity.ok().body(welcomeServiceInterface.getWelcomeMessageService());
    }

    /**
     * Update Welcome Message
     *
     * @param welcomePutRequestDTO
     * @return WelcomeGetResponseDTO
     */
    @Override
    public ResponseEntity<WelcomePutResponseDTO> updateWelcomeMessageController(WelcomePutRequestDTO welcomePutRequestDTO) {
        return ResponseEntity.ok().body(welcomeServiceInterface.updateWelcomeMessageService(welcomePutRequestDTO));
    }
}
