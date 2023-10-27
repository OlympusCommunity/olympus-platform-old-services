package com.olympus.platform.mapper;

import com.olympus.platform.entity.TypeUserEntity;
import com.olympus.platform.model.TypeUserResponseDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TypeUserMapper {

  TypeUserMapper INSTANCE = Mappers.getMapper(TypeUserMapper.class);

  TypeUserResponseDTO typeUserEntityconvertToTypeUserResponseDTO(TypeUserEntity typeUserEntity);

  List<TypeUserResponseDTO> listTypeUserEntityconvertToListTypeUserResponseDTO(
      List<TypeUserEntity> listTypeUserEntities);
}
