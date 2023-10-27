package com.olympus.platform.mapper;

import com.olympus.platform.entity.RepresenterEntity;
import com.olympus.platform.model.RepresenterDTO;
import com.olympus.platform.model.RepresenterGetResponseDTO;
import com.olympus.platform.model.RepresenterPutRequestDTO;
import java.util.Date;
import java.util.List;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RepresenterMapper {

  RepresenterMapper INSTANCE = Mappers.getMapper(RepresenterMapper.class);

  @Mappings({
    @Mapping(target = "representerLang", ignore = true),
    @Mapping(target = "creationDate", ignore = true),
    @Mapping(target = "deleteDate", ignore = true),
    @Mapping(target = "editionDate", ignore = true),
    @Mapping(target = "representerId", ignore = true),
    @Mapping(target = "status", ignore = true)
  })
  public RepresenterEntity mappingRepresenterEntity(RepresenterDTO representerDTO);

  @AfterMapping
  public default void addDefaultValues(@MappingTarget RepresenterEntity representerEntity) {
    representerEntity.setCreationDate(new Date());
    representerEntity.setStatus(Boolean.TRUE);
  }

  @Mappings({
    @Mapping(source = "representer.creationDate", target = "creationDate"),
    @Mapping(source = "representer.representerId", target = "representerId"),
    @Mapping(source = "representer.status", target = "status"),
    @Mapping(source = "representerPutRequestDTO.representerName", target = "representerName"),
    @Mapping(source = "representerPutRequestDTO.representerImage", target = "representerImage"),
    @Mapping(source = "representerPutRequestDTO.representerRole", target = "representerRole"),
    @Mapping(source = "representerPutRequestDTO.representerDesc", target = "representerDesc"),
    @Mapping(target = "deleteDate", ignore = true),
    @Mapping(target = "editionDate", ignore = true)
  })
  public RepresenterEntity mappingUpdateRepresenterEntity(
      RepresenterPutRequestDTO representerPutRequestDTO, RepresenterEntity representer);

  @AfterMapping
  public default void addUpdateValues(@MappingTarget RepresenterEntity representerEntity) {
    representerEntity.setEditionDate(new Date());
  }

  public RepresenterGetResponseDTO mappingRepresenterGetResponseDTO(
      RepresenterEntity representerEntity);

  public List<RepresenterGetResponseDTO> mappingRepresentersGetResponseList(
      List<RepresenterEntity> representers);
}
