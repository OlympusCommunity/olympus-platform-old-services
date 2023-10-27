package com.olympus.empire.service;

import com.olympus.exception.resource.InternalServerErrorException;
import com.olympus.exception.resource.ResourceConflictException;
import com.olympus.exception.resource.ResourceNotFoundException;
import com.olympus.objects.session.UserDTO;

public interface UserService {
	
	void guardarUsuario(UserDTO userDTO)
		      throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException;

}
