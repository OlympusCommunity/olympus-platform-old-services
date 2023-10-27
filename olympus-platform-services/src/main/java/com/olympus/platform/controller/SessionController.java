package com.olympus.platform.controller;

import com.olympus.platform.model.TypeUserResponseDTO;
import com.olympus.platform.model.UserGetResponseDTO;
import com.olympus.platform.model.UserPostRequestDTO;
import com.olympus.platform.model.UserPostResponseDTO;
import com.olympus.platform.model.UserRequestLoginDTO;
import com.olympus.platform.model.UserResponseLoginDTO;
import com.olympus.platform.service.TypeUserService;
import com.olympus.platform.service.UserService;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/session")
@CrossOrigin("*")
public class SessionController {

  @Autowired private TypeUserService typeUserService;

  @Autowired private UserService userService;

  @GetMapping(
      value = "/user/{userId}",
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<UserGetResponseDTO> getUserInformationController(
      @NotNull @PathVariable(value = "userId") String userId) {
    return new ResponseEntity<UserGetResponseDTO>(
        userService.getUserInformationService(userId), HttpStatus.OK);
  }

  @PostMapping(
      value = "/sign-up",
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<UserPostResponseDTO> postUserController(
      @Valid @RequestBody UserPostRequestDTO userPostRequestDTO) {
    return new ResponseEntity<UserPostResponseDTO>(
        userService.createUserService(userPostRequestDTO), HttpStatus.OK);
  }

  @PostMapping(
      value = "/sign-in",
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<UserResponseLoginDTO> loginController(
      @Valid @RequestBody UserRequestLoginDTO userRequestLoginDTO) {
    return new ResponseEntity<UserResponseLoginDTO>(
        userService.loginService(userRequestLoginDTO), HttpStatus.OK);
  }

  @PostMapping(
      value = "/logout",
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<UserResponseLoginDTO> logoutController(
      @NotNull @PathVariable(value = "userId") String userId) {
    return new ResponseEntity<UserResponseLoginDTO>(
        userService.logoutService(userId), HttpStatus.OK);
  }

  @GetMapping(
      value = "/types-users",
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<List<TypeUserResponseDTO>> getListTypeUsersController() {
    return new ResponseEntity<List<TypeUserResponseDTO>>(
        typeUserService.getListTypeUser(), HttpStatus.OK);
  }

  @GetMapping(
      value = "/type-user/{typeUserId}",
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<TypeUserResponseDTO> getTypeUserController(
      @NotNull @PathVariable(value = "typeUserId") Long typeUserId) {
    return new ResponseEntity<TypeUserResponseDTO>(
        typeUserService.getTypeUser(typeUserId), HttpStatus.OK);
  }
}
