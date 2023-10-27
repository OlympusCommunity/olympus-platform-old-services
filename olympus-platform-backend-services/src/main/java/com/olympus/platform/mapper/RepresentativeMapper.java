package com.olympus.platform.mapper;

import com.olympus.platform.entity.RepresentativeEntity;
import com.olympus.platform.model.representative.RepresentativeDTO;
import com.olympus.platform.model.representative.RepresentativeGetResponseDTO;
import com.olympus.platform.model.representative.RepresentativePutRequestDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import java.util.Date;
import java.util.List;

@Mapper
public interface RepresentativeMapper {

  RepresentativeMapper INSTANCE = Mappers.getMapper(RepresentativeMapper.class);

  @Mappings({
    @Mapping(target = "representativeLang", ignore = true),
    @Mapping(target = "creationDate", ignore = true),
    @Mapping(target = "deleteDate", ignore = true),
    @Mapping(target = "editionDate", ignore = true),
    @Mapping(target = "representativeId", ignore = true),
    @Mapping(target = "status", ignore = true)
  })
  RepresentativeEntity mappingRepresentativeEntity(RepresentativeDTO representativeDTO);

  @AfterMapping
  default void addDefaultValues(@MappingTarget RepresentativeEntity representativeEntity) {
    representativeEntity.setCreationDate(new Date());
    representativeEntity.setStatus(Boolean.TRUE);
  }

  @Mappings({
    @Mapping(source = "representative.creationDate", target = "creationDate"),
    @Mapping(source = "representative.representativeId", target = "representativeId"),
    @Mapping(source = "representative.status", target = "status"),
    @Mapping(source = "representativePutRequestDTO.representativeName", target = "representativeName"),
    @Mapping(source = "representativePutRequestDTO.representativeImage", target = "representativeImage"),
    @Mapping(source = "representativePutRequestDTO.representativeRole", target = "representativeRole"),
    @Mapping(source = "representativePutRequestDTO.representativeDesc", target = "representativeDesc"),
    @Mapping(target = "deleteDate", ignore = true),
    @Mapping(target = "editionDate", ignore = true)
  })
  RepresentativeEntity mappingUpdateRepresentativeEntity(
          RepresentativePutRequestDTO representativePutRequestDTO, RepresentativeEntity representative);

  @AfterMapping
  default void addUpdateValues(@MappingTarget RepresentativeEntity representativeEntity) {
    representativeEntity.setEditionDate(new Date());
  }

  RepresentativeGetResponseDTO mappingRepresentativeGetResponseDTO(
      RepresentativeEntity representativeEntity);

  List<RepresentativeGetResponseDTO> mappingRepresentativesGetResponseList(
      List<RepresentativeEntity> representatives);
}
