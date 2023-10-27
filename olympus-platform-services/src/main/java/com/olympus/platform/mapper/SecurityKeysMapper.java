package com.olympus.platform.mapper;

import com.olympus.platform.entity.SecurityKeysEntity;
import com.olympus.platform.entity.UserEntity;
import com.olympus.platform.model.SecurityKeyDTO;
import java.util.Date;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SecurityKeysMapper {

  SecurityKeysMapper INSTANCE = Mappers.getMapper(SecurityKeysMapper.class);

  public SecurityKeyDTO mappingSecurityKeyDTO(String keyPass, String ivKey, String saltKey);

  @Mapping(target = "codSecurityKey", ignore = true)
  @Mapping(source = "userEntity", target = "user")
  public SecurityKeysEntity convertSecurityKeyDTOForSecurityKeysEntity(
      SecurityKeyDTO securityKeyDTO, UserEntity userEntity);

  @AfterMapping
  public default void addDataToSecurityEntity(
      @MappingTarget SecurityKeysEntity securityKeysEntity) {
    securityKeysEntity.setCreationDate(new Date());
  }

  public SecurityKeyDTO convertSecurityEntityKeyForSecurityKeyDTO(
      SecurityKeysEntity securityKeysEntity);
}
