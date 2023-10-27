package com.olympus.platform.controller;

import com.olympus.platform.model.CmPrincipalGetResponseDTO;
import com.olympus.platform.model.CommunityPostRequestDTO;
import com.olympus.platform.model.CommunityPostResponseDTO;
import com.olympus.platform.service.CommunityService;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/community")
public class CommunityController {

  @Autowired private CommunityService communityService;

  @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<CommunityPostResponseDTO> createCommunityInformation(
      @NotNull @RequestParam(value = "profileId") String profileId,
      @Valid @RequestBody CommunityPostRequestDTO communityPostRequestDTO) {
    return new ResponseEntity<CommunityPostResponseDTO>(
        communityService.createCommunityInformationService(communityPostRequestDTO, profileId),
        HttpStatus.OK);
  }

  @GetMapping(
      value = "/profile",
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<List<CmPrincipalGetResponseDTO>> getCommunitiesForPrincipalPageController(
      @NotNull @RequestParam(value = "profileId") String profileId) {
    return new ResponseEntity<List<CmPrincipalGetResponseDTO>>(
        communityService.getCommunitiesForPrincipalPageService(profileId), HttpStatus.OK);
  }
}
