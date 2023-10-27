package com.olympus.empire.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.olympus.empire.mapper.RoleMapper;
import com.olympus.empire.repository.RoleRepository;
import com.olympus.empire.service.RoleService;
import com.olympus.exception.resource.InternalServerErrorException;
import com.olympus.exception.resource.ResourceConflictException;
import com.olympus.exception.resource.ResourceNotFoundException;
import com.olympus.objects.page.RoleDTO;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void guardarRol(RoleDTO roleDTO)
			throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException {
		log.info("Inicio del método: guardarRol");
		log.info("Atributos(roleDTO): " + roleDTO.toString());
		
		try {

			if (null == roleRepository.findByRoleName(roleDTO.getRoleName())) {
				roleRepository.save(RoleMapper.INSTANCE.convertRoleDTO2RoleEntity(roleDTO));
			}
			else {
				log.error("Error, Conflictos al registrar el rol");
				throw new ResourceConflictException("El rol con el nombre: " + roleDTO.getRoleName()
						+ "ya está registrado, Role: " + roleDTO.toString());
			}
			
		} catch (Exception ex) {
			log.error("Error consultando del método: guardarRol");
			log.error("Exception: " + ex.getMessage());
			throw new InternalServerErrorException("Error en respuesta del servidor");
		}
		
	}

}
