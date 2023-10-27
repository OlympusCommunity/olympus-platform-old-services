package com.olympus.empire.controller;

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
import com.olympus.empire.service.UserService;
import com.olympus.objects.session.UserDTO;
import com.olympus.exception.resource.InternalServerErrorException;
import com.olympus.exception.resource.ResourceConflictException;
import com.olympus.exception.resource.ResourceNotFoundException;
import com.olympus.exception.resource.ValidationException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/users")
@Api
@Validated
public class UserController {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "Registrar un usuario", notes = "Para guardar un usuario se identificara el tipo de usuario que se desea registrar", response = UserDTO.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Se registro correctamente el usuario", response = UserDTO.class),
			@ApiResponse(code = 404, message = "Recurso no encontrado", response = ResourceNotFoundException.class),
			@ApiResponse(code = 200, message = "Validación de negocio", response = ValidationException.class) })
	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> saveUserService (@Valid @RequestBody UserDTO userDTO)
			throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException {
		userService.guardarUsuario(userDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
