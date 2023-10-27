package com.olympus.empire.mapper;

import java.util.Date;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.olympus.empire.domain.SecurityKeysEntity;
import com.olympus.empire.domain.UserEntity;
import com.olympus.objects.security.SecurityKeyDTO;

@Mapper
public interface SecurityKeysMapper {
	
	SecurityKeysMapper INSTANCE = Mappers.getMapper(SecurityKeysMapper.class);
	
	SecurityKeyDTO convertSecurityEntityKeyForSecurityKeyDTO (SecurityKeysEntity securityKeysEntity);

	default SecurityKeysEntity convertSecurityKeyDTOForSecurityKeysEntity (SecurityKeyDTO securityKeyDTO, UserEntity userEntity) {
		SecurityKeysEntity securityKeysEntity = new SecurityKeysEntity();
		securityKeysEntity.setFechaCreacion(new Date());
		securityKeysEntity.setIvKey(securityKeyDTO.getIvKey());
		securityKeysEntity.setKeyPass(securityKeyDTO.getKeyPass());
		securityKeysEntity.setSaltKey(securityKeyDTO.getSaltKey());
		securityKeysEntity.setUser(userEntity);
		return securityKeysEntity;
	}
	
	default SecurityKeyDTO mappingSecurityKeyDTO (String keyPass, String ivKey, String saltKey) {
		SecurityKeyDTO securityKeyDTO = new SecurityKeyDTO();
		securityKeyDTO.setIvKey(ivKey);
		securityKeyDTO.setKeyPass(keyPass);
		securityKeyDTO.setSaltKey(saltKey);
		return securityKeyDTO;
	}

}
