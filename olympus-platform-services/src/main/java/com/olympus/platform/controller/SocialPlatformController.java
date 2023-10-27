package com.olympus.platform.controller;

import com.olympus.platform.model.SocialPtPostRequestDTO;
import com.olympus.platform.model.SocialPtPostResponseDTO;
import com.olympus.platform.service.SocialPaltformService;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/platform")
public class SocialPlatformController {

  @Autowired private SocialPaltformService socialPaltformService;

  @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<SocialPtPostResponseDTO> createSocialPlatformController(
      @NotNull @RequestParam(value = "profileId") String profileId,
      @Valid @RequestBody List<SocialPtPostRequestDTO> socialPlatformList) {
    return new ResponseEntity<SocialPtPostResponseDTO>(
        socialPaltformService.createSocialPlatformToCommunity(socialPlatformList, profileId),
        HttpStatus.OK);
  }
}
