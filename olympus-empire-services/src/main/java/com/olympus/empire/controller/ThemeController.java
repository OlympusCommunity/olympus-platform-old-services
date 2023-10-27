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
import com.olympus.empire.service.ThemeService;
import com.olympus.exception.resource.InternalServerErrorException;
import com.olympus.exception.resource.ResourceConflictException;
import com.olympus.exception.resource.ResourceNotFoundException;
import com.olympus.exception.resource.ValidationException;
import com.olympus.objects.page.ThemeDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/theme")
@Api
@Validated
public class ThemeController {
	
	@Autowired
	private ThemeService themeService;
	
	@ApiOperation(value = "Registrar una tematica", notes = "Para guardar una tematica y sus subtematicas", response = ThemeDTO.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Se registro correctamente la tematica", response = ThemeDTO.class),
			@ApiResponse(code = 404, message = "Recurso no encontrado", response = ResourceNotFoundException.class),
			@ApiResponse(code = 200, message = "Validación de negocio", response = ValidationException.class) })
	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> saveCategoryService (@Valid @RequestBody ThemeDTO themeDTO)
			throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException {
		themeService.guardarTema(themeDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
