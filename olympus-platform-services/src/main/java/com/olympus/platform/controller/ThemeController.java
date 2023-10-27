package com.olympus.platform.controller;

import com.olympus.platform.model.ThemePostRequestDTO;
import com.olympus.platform.model.ThemePostResponseDTO;
import com.olympus.platform.service.ThemeService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/theme")
public class ThemeController {

  @Autowired private ThemeService themeService;

  @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<ThemePostResponseDTO> createThemeController(
      @Valid @RequestBody ThemePostRequestDTO themePostRequestDTO) {
    return new ResponseEntity<ThemePostResponseDTO>(
        themeService.createThemeAndSubthemesService(themePostRequestDTO), HttpStatus.OK);
  }
}
