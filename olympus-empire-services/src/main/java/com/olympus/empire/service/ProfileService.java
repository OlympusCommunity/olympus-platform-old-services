package com.olympus.empire.service;

import com.olympus.exception.resource.InternalServerErrorException;
import com.olympus.exception.resource.ResourceConflictException;
import com.olympus.exception.resource.ResourceNotFoundException;
import com.olympus.objects.session.ProfileDTO;
import com.olympus.objects.session.ProfileViewDTO;

public interface ProfileService {
	
	void guardarPerfil (ProfileDTO profileDTO) 
			throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException;
	
	ProfileViewDTO obtenerPerfil (String profileId) 
			throws ResourceNotFoundException, InternalServerErrorException;
	
	void actualizarPerfil (String profileId, ProfileDTO profileDTO)
			throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException;
	
}
