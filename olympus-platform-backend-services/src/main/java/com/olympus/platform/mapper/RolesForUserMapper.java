package com.olympus.platform.mapper;

import com.olympus.platform.entity.RoleForUserEntity;
import com.olympus.platform.entity.UserEntity;
import com.olympus.platform.entity.UserRoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RolesForUserMapper {

    RolesForUserMapper INSTANCE = Mappers.getMapper(RolesForUserMapper.class);

    RoleForUserEntity mappingAssignedRolesForUser (UserRoleEntity userRole, UserEntity user);

}
