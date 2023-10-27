package com.olympus.platform.mapper;

import com.olympus.platform.entity.RepresentativeEntity;
import com.olympus.platform.entity.WelcomeEntity;
import com.olympus.platform.model.welcome.WelcomeGetResponseDTO;
import com.olympus.platform.model.welcome.WelcomePostRequestDTO;
import com.olympus.platform.model.welcome.WelcomePutRequestDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import java.util.Date;
import java.util.List;

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
  WelcomeEntity convertToWelcomeEntity(WelcomePostRequestDTO welcomePostRequestDTO);

  @AfterMapping
  default void addDatesAndStatus(@MappingTarget WelcomeEntity welcomeEntity) {
    welcomeEntity.setCreationDate(new Date());
    welcomeEntity.setStatus(Boolean.TRUE);
  }

  WelcomeGetResponseDTO convertToWelcomeGetResponse(
          WelcomeEntity welcomeEntity, List<RepresentativeEntity> representatives);

  @Mappings({
    @Mapping(target = "welcomeLang", source = "welcomePutRequestDTO.language"),
    @Mapping(target = "deleteDate", ignore = true),
    @Mapping(target = "editionDate", ignore = true)
  })
  WelcomeEntity mappingUpdateWelcomeEntity(
          WelcomePutRequestDTO welcomePutRequestDTO, Date creationDate, Boolean status);

  @AfterMapping
  default void updateWelcomeEntityAfterMapping(@MappingTarget WelcomeEntity welcomeEntity) {
    welcomeEntity.setEditionDate(new Date());
  }
}
