package com.olympus.empire.service;

import java.util.List;
import com.olympus.exception.resource.InternalServerErrorException;
import com.olympus.exception.resource.ResourceConflictException;
import com.olympus.exception.resource.ResourceNotFoundException;
import com.olympus.objects.page.CommunityDTO;
import com.olympus.objects.page.CommunityViewDTO;
import com.olympus.objects.page.ThemeCommunityDTO;

public interface CommunityService {
	
	void guardarComunidadCompleta (CommunityDTO communityDTO, String profileId) throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException;
	
	void guardarTematicasAndSubTematicasForComunidad (List<ThemeCommunityDTO> listaTemasPorComunidades) 
			throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException;
	
	void editarTematicasAndSubTematicasForComunidad (List<ThemeCommunityDTO> listaTemasPorComunidades) 
			throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException;
	
	void guardarRolesAtPerfilesForComunidad (List<Long> roles, List<String> profiles) 
			throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException;
	
	void editarRolesAtPerfilesForComunidad (List<Long> roles, List<String> profiles) 
			throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException;
	
	void editarComunidadCompleta (String communityId, CommunityDTO communityDTO)
			throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException;
	
	void desaparecerComunidadCompleta (String communityId)
			throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException;
	
	void eliminarComunidadCompleta (String communityId)
			throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException;
	
	CommunityViewDTO obtenerComunidadCompleta (String communityId) 
			throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException;

}
