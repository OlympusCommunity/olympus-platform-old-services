package com.olympus.platform.mapper;

import com.olympus.platform.entity.SecurityKeyEntity;
import com.olympus.platform.entity.UserEntity;
import com.olympus.platform.model.security.SecurityKeyDTO;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.Date;

@Mapper
public interface SecurityKeyMapper {

    SecurityKeyMapper INSTANCE = Mappers.getMapper(SecurityKeyMapper.class);

    SecurityKeyDTO mappingSecurityKeyDTO(String keyPass, String ivKey, String saltKey);

    @Mapping(target = "codSecurityKey", ignore = true)
    @Mapping(target = "user", source = "userEntity")
    SecurityKeyEntity convertSecurityKeyDTOForSecurityKeysEntity(
            SecurityKeyDTO securityKeyDTO, UserEntity userEntity);

    @AfterMapping
    default void addDataToSecurityEntity(
            @MappingTarget SecurityKeyEntity securityKeysEntity) {
        securityKeysEntity.setCreationDate(new Date());
    }

    SecurityKeyDTO convertSecurityEntityKeyForSecurityKeyDTO(
            SecurityKeyEntity securityKeysEntity);
}