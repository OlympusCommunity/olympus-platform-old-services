package com.olympus.platform.controller;

import com.olympus.platform.model.RolePostRequestDTO;
import com.olympus.platform.model.RolePostResponseDTO;
import com.olympus.platform.service.RoleService;
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

@Validated
@RestController
@RequestMapping("/role")
public class RoleController {

  @Autowired private RoleService roleService;

  @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<RolePostResponseDTO> createRoleController(
      @Valid @RequestBody RolePostRequestDTO rolePostRequestDTO) {
    return new ResponseEntity<RolePostResponseDTO>(
        roleService.createRoleService(rolePostRequestDTO), HttpStatus.OK);
  }
}
