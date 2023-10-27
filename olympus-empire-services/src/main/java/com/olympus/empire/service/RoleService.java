package com.olympus.empire.service;

import com.olympus.exception.resource.InternalServerErrorException;
import com.olympus.exception.resource.ResourceConflictException;
import com.olympus.exception.resource.ResourceNotFoundException;
import com.olympus.objects.page.RoleDTO;

public interface RoleService {
	
	void guardarRol (RoleDTO roleDTO) throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException;

}
