package com.olympus.empire.mapper;

import java.util.Date;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.olympus.empire.domain.TypeEntity;
import com.olympus.empire.domain.UserEntity;
import com.olympus.objects.session.UserDTO;

@Mapper
public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	default UserEntity convertUserDTO2UserEntity (UserDTO userDTO, String idGenerated, TypeEntity typeEntity) {
		UserEntity userEntity = new UserEntity();
		userEntity.setEmail(userDTO.getEmail());
		userEntity.setFechaCreacion(new Date());
		userEntity.setFechaEdicion(null);
		userEntity.setPassword(userDTO.getPassword());
		userEntity.setStatus(Boolean.TRUE);
		userEntity.setTypeEntity(typeEntity);
		userEntity.setUserId(idGenerated);
		userEntity.setUsername(userDTO.getUsername());
		return userEntity;
	}

}
