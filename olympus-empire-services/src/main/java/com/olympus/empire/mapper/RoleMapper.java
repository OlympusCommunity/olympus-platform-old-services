package com.olympus.empire.mapper;

import java.util.Date;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import com.olympus.empire.domain.RoleEntity;
import com.olympus.objects.page.RoleDTO;

@Mapper
public interface RoleMapper {
	
	RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
	
	@Mapping(target = "fechaCreacion" , ignore = true)
	@Mapping(target = "fechaEdicion" , ignore = true)
	@Mapping(target = "status" , ignore = true)
	@Mapping(target = "roleId" , ignore = true)
	RoleEntity convertRoleDTO2RoleEntity (RoleDTO roleDto) ;
	
	@AfterMapping
	default void roleEntityAddStatusAndDatesWithRoleId (@MappingTarget RoleEntity roleEntity) {
		roleEntity.setFechaCreacion(new Date());
		roleEntity.setFechaEdicion(null);
		roleEntity.setStatus(Boolean.TRUE);
	}

}
