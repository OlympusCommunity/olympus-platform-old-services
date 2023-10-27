package com.olympus.platform.mapper;

import com.olympus.platform.entity.CommunityEntity;
import com.olympus.platform.entity.CommunityManagementEntity;
import com.olympus.platform.entity.ProfileEntity;
import com.olympus.platform.entity.RoleEntity;
import java.util.Date;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommunityManagementMapper {

  CommunityManagementMapper INSTANCE = Mappers.getMapper(CommunityManagementMapper.class);

  @Mappings({
    @Mapping(target = "comProfId", ignore = true),
    @Mapping(target = "editionDate", ignore = true),
    @Mapping(target = "deleteDate", ignore = true),
    @Mapping(target = "creationDate", ignore = true),
    @Mapping(target = "status", ignore = true)
  })
  public CommunityManagementEntity mappingCommunityManagement(
      ProfileEntity profile, RoleEntity role, CommunityEntity community);

  @AfterMapping
  default void addDefaultDataForCommunityManagement(
      @MappingTarget CommunityManagementEntity communityManagement) {
    communityManagement.setCreationDate(new Date());
    communityManagement.setStatus(Boolean.TRUE);
  }
}
