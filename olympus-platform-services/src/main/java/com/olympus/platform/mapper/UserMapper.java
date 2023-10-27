package com.olympus.platform.mapper;

import com.olympus.platform.entity.TypeUserEntity;
import com.olympus.platform.entity.UserEntity;
import com.olympus.platform.model.AuditDTO;
import com.olympus.platform.model.UserGetResponseDTO;
import com.olympus.platform.model.UserPostRequestDTO;
import com.olympus.platform.model.UserResponseLoginDTO;
import java.util.Date;
import java.util.List;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  @Mappings({
    @Mapping(target = "creationDate", ignore = true),
    @Mapping(target = "deleteDate", ignore = true),
    @Mapping(target = "editionDate", ignore = true),
    @Mapping(target = "status", ignore = true),
    @Mapping(source = "typeUserList", target = "userTypes"),
    @Mapping(source = "idGenerated", target = "userId")
  })
  public UserEntity mappingUserEntity(
      UserPostRequestDTO userPostRequestDTO, String idGenerated, List<TypeUserEntity> typeUserList);

  @AfterMapping
  public default void addDataForUserEntity(@MappingTarget UserEntity userEntity) {
    userEntity.setCreationDate(new Date());
    userEntity.setStatus(Boolean.TRUE);
  }

  public UserResponseLoginDTO mappingUserResponseLoginDTO(String message, AuditDTO info);

  public UserGetResponseDTO mappingUserGetResponseDTO(
      UserEntity userEntity, List<TypeUserEntity> userTypes);
}
