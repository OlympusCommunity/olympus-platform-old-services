package com.olympus.empire.controller;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.olympus.empire.service.ProfileService;
import com.olympus.exception.resource.InternalServerErrorException;
import com.olympus.exception.resource.ResourceConflictException;
import com.olympus.exception.resource.ResourceNotFoundException;
import com.olympus.exception.resource.ValidationException;
import com.olympus.objects.session.ProfileDTO;
import com.olympus.objects.session.ProfileViewDTO;
import com.olympus.objects.session.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/profiles")
@Api
@Validated
public class ProfileController {
	
	@Autowired
	private ProfileService profileService;
	
	@ApiOperation(value = "Registrar un perfil", notes = "Para guardar un perfil se identificara el usuario que se desea registrar", response = ProfileDTO.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Se registro correctamente el perfil", response = UserDTO.class),
			@ApiResponse(code = 404, message = "Recurso no encontrado", response = ResourceNotFoundException.class),
			@ApiResponse(code = 200, message = "Validación de negocio", response = ValidationException.class) })
	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> saveProfileService (@Valid @RequestBody ProfileDTO profileDTO)
			throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException {
		profileService.guardarPerfil(profileDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Obtener un perfil", notes = "Para obtener un perfil se identificara por el codigo o id.", response = ProfileDTO.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Se encontró el perfil exitosamente", response = ProfileViewDTO.class),
			@ApiResponse(code = 404, message = "Recurso no encontrado", response = ResourceNotFoundException.class),
			@ApiResponse(code = 200, message = "Validación de negocio", response = ValidationException.class) })
	@GetMapping(value = "/{profileId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ProfileViewDTO> getProfileService (@NotNull @PathVariable(value = "profileId") String profileId)
			throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException {
		return new ResponseEntity<>(profileService.obtenerPerfil(profileId), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Actualizar un perfil", notes = "Para actualizar un perfil se identificara por el codigo o id y se actualiza con el body especificado", response = ProfileDTO.class)
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "Se actualizó correctamente el perfil", response = UserDTO.class),
			@ApiResponse(code = 404, message = "Recurso no encontrado", response = ResourceNotFoundException.class),
			@ApiResponse(code = 200, message = "Validación de negocio", response = ValidationException.class) })
	@PutMapping(value = "/{profileId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> updateProfileService (@NotNull @PathVariable(value = "profileId") String profileId, @Valid @RequestBody ProfileDTO profileDTO)
			throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException {
		profileService.actualizarPerfil(profileId, profileDTO);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
