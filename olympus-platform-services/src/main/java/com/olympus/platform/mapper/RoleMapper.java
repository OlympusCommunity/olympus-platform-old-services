package com.olympus.platform.mapper;

import com.olympus.platform.entity.RoleEntity;
import com.olympus.platform.model.RolePostRequestDTO;
import java.util.Date;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper {

  RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

  @Mappings({
    @Mapping(target = "creationDate", ignore = true),
    @Mapping(target = "deleteDate", ignore = true),
    @Mapping(target = "editionDate", ignore = true),
    @Mapping(target = "roleId", ignore = true),
    @Mapping(target = "status", ignore = true)
  })
  public RoleEntity mappingRoleEntity(RolePostRequestDTO rolePostRequestDTO);

  @AfterMapping
  public default void addDataForRegisterRole(@MappingTarget RoleEntity roleEntity) {
    roleEntity.setCreationDate(new Date());
    roleEntity.setStatus(Boolean.TRUE);
  }
}
