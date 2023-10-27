package com.olympus.empire.service.impl;

import java.util.Optional;
import java.util.UUID;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.olympus.empire.domain.SecurityKeysEntity;
import com.olympus.empire.domain.TypeEntity;
import com.olympus.empire.domain.UserEntity;
import com.olympus.empire.mapper.SecurityKeysMapper;
import com.olympus.empire.mapper.UserMapper;
import com.olympus.empire.repository.SecurityKeyRepository;
import com.olympus.empire.repository.TypeRepository;
import com.olympus.empire.repository.UserRepository;
import com.olympus.empire.service.UserService;
import com.olympus.exception.resource.InternalServerErrorException;
import com.olympus.exception.resource.ResourceBadRequestException;
import com.olympus.exception.resource.ResourceConflictException;
import com.olympus.exception.resource.ResourceNotFoundException;
import com.olympus.objects.security.SecurityKeyDTO;
import com.olympus.objects.session.UserDTO;
import com.olympus.empire.util.Constantes;
import com.olympus.empire.util.UtilEncrypting;
import com.olympus.empire.util.UtilValidation;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private TypeRepository typeRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private SecurityKeyRepository securityKeyRepository;

	@Override
	public void guardarUsuario(UserDTO userDTO)
			throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException {

		log.info("Inicio del método: guardarUsuario");
		log.info("Atributos(UserDTO): " + userDTO.toString());

		TypeEntity type = typeRepository.findById(userDTO.getTypeId())
				.orElseThrow(() -> new ResourceNotFoundException("Tipo de usuario no registrado en la bd"));

		try {

			if (!userDTO.getPassword().equals(userDTO.getRepeatPassword())) {
				log.error("Error, las contraseñas no coiciden");
				throw new ResourceBadRequestException("Las contraseñas no soiciden");
			} else if (UtilValidation.isNull(userRepository.findByUsername(userDTO.getUsername()))) {
				UtilEncrypting utilEncrypting = new UtilEncrypting();
				
				SecurityKeyDTO securityKeyDTO = generateSecurityKeys();
				userDTO.setPassword(
						utilEncrypting.aesEncript(
							userDTO.getPassword(), 
							securityKeyDTO));

				UserEntity userEntity =
						userRepository.save(UserMapper.INSTANCE.convertUserDTO2UserEntity(
								userDTO, idGenerator(type.getAlias(), userDTO.getUsername()), type));
				
				securityKeyRepository.save(
						SecurityKeysMapper.INSTANCE.convertSecurityKeyDTOForSecurityKeysEntity(
								securityKeyDTO, userEntity));
				log.info("Se registró el usuario correctamente");
			} else {
				log.error("Error, Conflictos al registrar el usuario");
				throw new ResourceConflictException("El usuario con el username: " + userDTO.getUsername()
						+ "ya está registrado, User: " + userDTO.getUsername());
			}

		} catch (Exception ex) {
			log.error("Error consultando del método: guardarUsuario");
			log.error("Exception: " + ex.getMessage());
			throw new InternalServerErrorException("Error en respuesta del servidor");
		}
	}
	
	public String idGenerator (String aliasType, String username) {
		log.info("Generar un codigo de usuario");
		
		String idGenerated = 
				aliasType.toUpperCase().substring(0, 2) + username.toUpperCase().substring(0, 2) + UUID.randomUUID().toString().toUpperCase().substring(0, 21);
		
		Optional<UserEntity> userEntity = userRepository.findById(idGenerated);
		
		if (userEntity.isEmpty()) {
			return idGenerated;
		}
		else {
			return idGenerator(aliasType, username);
		}
	}
	
	public SecurityKeyDTO generateSecurityKeys () {
		log.info("Generar codigos de seguridad");

		String keyPass = 
				RandomStringUtils.randomAlphanumeric(Constantes.LONG_SECURITY_KEYS_32);
		String ivKey = 
				RandomStringUtils.randomAlphanumeric(Constantes.LONG_SECURITY_KEYS_16);
		String saltKey = 
				RandomStringUtils.randomAlphanumeric(Constantes.LONG_SECURITY_KEYS_32);
		
		SecurityKeyDTO securityKeyDTO = SecurityKeysMapper.INSTANCE.mappingSecurityKeyDTO(keyPass, ivKey, saltKey);
		
		SecurityKeysEntity securityKeyEntity = 
				securityKeyRepository.findByKeyPassAndIvKeyAndSaltKey(
						securityKeyDTO.getKeyPass(), securityKeyDTO.getIvKey(), securityKeyDTO.getSaltKey());
		
		if (null == securityKeyEntity) {
			return securityKeyDTO;
		}
		else {
			return generateSecurityKeys();
		}
	}
	
}
