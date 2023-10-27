package com.olympus.empire.service;

import java.util.List;

import com.olympus.exception.resource.InternalServerErrorException;
import com.olympus.exception.resource.ResourceConflictException;
import com.olympus.exception.resource.ResourceNotFoundException;
import com.olympus.objects.page.SubThemeDTO;
import com.olympus.objects.page.ThemeDTO;

public interface ThemeService {
	
	void guardarTema (ThemeDTO themeDTO) throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException;
	
	void agregarSubThemeAlTema (Long themeId, List<SubThemeDTO> subThemesDTO) throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException;
	
	ThemeDTO obtenerTemaWithSubTemas (Long themeId) throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException;
	
	void eliminarTema (Long themeId) throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException;

}
