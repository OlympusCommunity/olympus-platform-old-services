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
import com.olympus.empire.service.RoleService;
import com.olympus.exception.resource.InternalServerErrorException;
import com.olympus.exception.resource.ResourceConflictException;
import com.olympus.exception.resource.ResourceNotFoundException;
import com.olympus.exception.resource.ValidationException;
import com.olympus.objects.page.RoleDTO;
import com.olympus.objects.session.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/roles")
@Api
@Validated
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@ApiOperation(value = "Registrar un rol", notes = "Para guardar un rol se verificara que no se repita", response = RoleDTO.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Se registro correctamente el perfil", response = UserDTO.class),
			@ApiResponse(code = 404, message = "Recurso no encontrado", response = ResourceNotFoundException.class),
			@ApiResponse(code = 200, message = "Validación de negocio", response = ValidationException.class) })
	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> saveProfileService (@Valid @RequestBody RoleDTO roleDTO)
			throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException {
		roleService.guardarRol(roleDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
