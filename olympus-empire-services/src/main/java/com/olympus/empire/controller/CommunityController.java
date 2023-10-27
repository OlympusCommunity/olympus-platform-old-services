package com.olympus.empire.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.olympus.empire.service.CommunityService;
import com.olympus.exception.resource.InternalServerErrorException;
import com.olympus.exception.resource.ResourceConflictException;
import com.olympus.exception.resource.ResourceNotFoundException;
import com.olympus.exception.resource.ValidationException;
import com.olympus.objects.page.CommunityDTO;
import com.olympus.objects.session.ProfileDTO;
import com.olympus.objects.session.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/communities")
@Api
@Validated
public class CommunityController {
	
	@Autowired
	private CommunityService communityService;
	
	@ApiOperation(value = "Registrar una comunidad", notes = "Para guardar una comunidad se requiere registrar sus temas y perfiles", response = ProfileDTO.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Se registro correctamente la comunidad", response = UserDTO.class),
			@ApiResponse(code = 404, message = "Recurso no encontrado", response = ResourceNotFoundException.class),
			@ApiResponse(code = 200, message = "Validación de negocio", response = ValidationException.class) })
	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> saveCompleteCommunityService (@NotNull @PathParam(value = "profileId") String profileId,
			@Valid @RequestBody CommunityDTO communityDTO)
			throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException {
		communityService.guardarComunidadCompleta(communityDTO, profileId);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
