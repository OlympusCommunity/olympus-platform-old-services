package com.olympus.platform.controller;

import com.olympus.platform.model.ProfileGetResponseDTO;
import com.olympus.platform.model.ProfilePostRequestDTO;
import com.olympus.platform.model.ProfilePostResponseDTO;
import com.olympus.platform.model.ProfileThemePostRequestDTO;
import com.olympus.platform.model.ProfileThemePostResponseDTO;
import com.olympus.platform.service.ProfileService;
import com.olympus.platform.service.ProfileThemeService;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/profile")
public class ProfileController {

  @Autowired private ProfileService profileService;
  @Autowired private ProfileThemeService profileThemeService;

  @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<ProfilePostResponseDTO> createProfileInformationController(
      @Valid @RequestBody ProfilePostRequestDTO profilePostRequestDTO) {
    return new ResponseEntity<ProfilePostResponseDTO>(
        profileService.createProfileService(profilePostRequestDTO), HttpStatus.OK);
  }

  @GetMapping(
      value = "/{profileId}",
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<ProfileGetResponseDTO> getProfileInformationController(
      @NotNull @PathVariable(value = "profileId") String profileId,
      @NotNull @RequestParam(value = "userId") String userId) {
    return new ResponseEntity<ProfileGetResponseDTO>(
        profileService.getProfileInformationService(profileId, userId), HttpStatus.OK);
  }

  @PostMapping(
      value = "/themes/{profileId}",
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<ProfileThemePostResponseDTO> createThemesForProfileController(
      @Valid @RequestBody ProfileThemePostRequestDTO profileThemePostRequestDTO,
      @NotNull @PathVariable(value = "profileId") String profileId,
      @NotNull @RequestParam(value = "userId") String userId) {
    return new ResponseEntity<ProfileThemePostResponseDTO>(
        profileThemeService.createThemesForProfileService(profileThemePostRequestDTO, profileId),
        HttpStatus.OK);
  }
}
