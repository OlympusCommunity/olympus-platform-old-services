package com.olympus.platform.controller;

import com.olympus.platform.model.welcome.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Api(value = "welcome", tags = {"Welcome Messages"})
@RequestMapping(value = "/api/principal/v1/welcome", produces = MediaType.APPLICATION_JSON_VALUE)
public interface WelcomeController {

    /**
     * Create Welcome Message
     *
     * @return WelcomeGetResponseDTO
     */
    @ApiOperation(
            value = "Create Welcome Message"
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok", response = WelcomePostResponseDTO.class),
            @ApiResponse(code = 503, message = "Service Unavailable")
    })
    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<WelcomePostResponseDTO> createWelcomeMessageController (@Valid @RequestBody WelcomePostRequestDTO welcomePostRequestDTO);

    /**
     * Get Welcome Message
     *
     * @return WelcomeGetResponseDTO
     */
    @ApiOperation(
            value = "Get Welcome Message"
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok", response = WelcomeGetResponseDTO.class),
            @ApiResponse(code = 503, message = "Service Unavailable")
    })
    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<WelcomeGetResponseDTO> getWelcomeMessageController ();

    /**
     * Update Welcome Message
     *
     * @return WelcomeGetResponseDTO
     */
    @ApiOperation(
            value = "Update Welcome Message"
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok", response = WelcomePutResponseDTO.class),
            @ApiResponse(code = 503, message = "Service Unavailable")
    })
    @PutMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<WelcomePutResponseDTO> updateWelcomeMessageController (@Valid @RequestBody WelcomePutRequestDTO welcomePutRequestDTO);

}
