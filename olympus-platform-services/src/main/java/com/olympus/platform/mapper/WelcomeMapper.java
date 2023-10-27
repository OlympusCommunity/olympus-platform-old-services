package com.olympus.platform.mapper;

import com.olympus.platform.entity.RepresenterEntity;
import com.olympus.platform.entity.WelcomeEntity;
import com.olympus.platform.model.WelcomeGetResponseDTO;
import com.olympus.platform.model.WelcomePostRequestDTO;
import com.olympus.platform.model.WelcomePutRequestDTO;
import java.util.Date;
import java.util.List;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WelcomeMapper {

  WelcomeMapper INSTANCE = Mappers.getMapper(WelcomeMapper.class);

  @Mappings({
    @Mapping(target = "creationDate", ignore = true),
    @Mapping(target = "deleteDate", ignore = true),
    @Mapping(target = "editionDate", ignore = true),
    @Mapping(target = "status", ignore = true),
    @Mapping(target = "welcomeId", ignore = true),
    @Mapping(target = "welcomeLang", source = "language")
  })
  public WelcomeEntity convertToWelcomeEntity(WelcomePostRequestDTO welcomePostRequestDTO);

  @AfterMapping
  public default void addDatesAndStatus(@MappingTarget WelcomeEntity welcomeEntity) {
    welcomeEntity.setCreationDate(new Date());
    welcomeEntity.setStatus(Boolean.TRUE);
  }

  public WelcomeGetResponseDTO convertToWelcomeGetResponse(
      WelcomeEntity welcomeEntity, List<RepresenterEntity> representers);

  @Mappings({
    @Mapping(target = "welcomeLang", source = "welcomePutRequestDTO.language"),
    @Mapping(target = "deleteDate", ignore = true),
    @Mapping(target = "editionDate", ignore = true)
  })
  public WelcomeEntity mappingUpdateWelcomeEntity(
      WelcomePutRequestDTO welcomePutRequestDTO, Date creationDate, Boolean status);

  @AfterMapping
  public default void updateWelcomeEntityAfterMapping(@MappingTarget WelcomeEntity welcomeEntity) {
    welcomeEntity.setEditionDate(new Date());
  }
}
