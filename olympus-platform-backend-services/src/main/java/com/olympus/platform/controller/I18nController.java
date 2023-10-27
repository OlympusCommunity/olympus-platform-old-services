package com.olympus.platform.controller;

import com.olympus.platform.model.welcome.WelcomeGetResponseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Api(value = "i18n", tags = {"I18n"})
@RequestMapping(value = "/api/services/v1/i18n", produces = MediaType.APPLICATION_JSON_VALUE)
public interface I18nController {

    /**
     * Get Value of I18n
     *
     * @return String
     */
    @ApiOperation(
            value = "Get Value of I18n"
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok", response = WelcomeGetResponseDTO.class),
            @ApiResponse(code = 503, message = "Service Unavailable")
    })
    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<String> getValueController (@RequestParam("key") String key, @RequestParam("lang") String lang);

}
