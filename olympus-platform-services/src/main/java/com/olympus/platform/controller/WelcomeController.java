package com.olympus.platform.controller;

import com.olympus.platform.model.RepresenterGetResponseDTO;
import com.olympus.platform.model.RepresenterPutRequestDTO;
import com.olympus.platform.model.RepresenterPutResponseDTO;
import com.olympus.platform.model.WelcomeGetResponseDTO;
import com.olympus.platform.model.WelcomePostRequestDTO;
import com.olympus.platform.model.WelcomePostResponseDTO;
import com.olympus.platform.model.WelcomePutRequestDTO;
import com.olympus.platform.model.WelcomePutResponseDTO;
import com.olympus.platform.service.RepresenterService;
import com.olympus.platform.service.WelcomeService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/welcome")
@CrossOrigin("*")
public class WelcomeController {

  @Autowired private WelcomeService welcomeService;

  @Autowired private RepresenterService representerService;

  @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<WelcomePostResponseDTO> createWelcomMessageController(
      @Valid @RequestBody WelcomePostRequestDTO welcomePostRequestDTO) {
    return new ResponseEntity<WelcomePostResponseDTO>(
        welcomeService.createWelcomMessageService(welcomePostRequestDTO), HttpStatus.OK);
  }

  @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<WelcomeGetResponseDTO> getWelcomeMessageController() {
    return new ResponseEntity<WelcomeGetResponseDTO>(
        welcomeService.getWelcomeMessageService(), HttpStatus.OK);
  }

  @PutMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<WelcomePutResponseDTO> updateWelcomeMessageController(
      @Valid @RequestBody WelcomePutRequestDTO welcomePutRequestDTO) {
    return new ResponseEntity<WelcomePutResponseDTO>(
        welcomeService.updateWelcomeMessageService(welcomePutRequestDTO), HttpStatus.OK);
  }

  @GetMapping(
      value = "/representers",
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<List<RepresenterGetResponseDTO>> getRepresentersController() {
    return new ResponseEntity<List<RepresenterGetResponseDTO>>(
        representerService.getRepresentersService(), HttpStatus.OK);
  }

  @PutMapping(
      value = "/representer",
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<RepresenterPutResponseDTO> updateRepresenterController(
      @Valid @RequestBody RepresenterPutRequestDTO representerPutRequestDTO) {
    return new ResponseEntity<RepresenterPutResponseDTO>(
        representerService.updateRepresenterService(representerPutRequestDTO), HttpStatus.OK);
  }
}
