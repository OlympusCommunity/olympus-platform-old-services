package com.olympus.platform.mapper;

import com.olympus.platform.entity.CountryEntity;
import com.olympus.platform.entity.ProfileEntity;
import com.olympus.platform.entity.ThelephoneEntity;
import com.olympus.platform.model.ThelephoneDTO;
import java.util.Date;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ThelephoneMapper {

  ThelephoneMapper INSTANCE = Mappers.getMapper(ThelephoneMapper.class);

  @Mappings({
    @Mapping(target = "creationDate", ignore = true),
    @Mapping(target = "deleteDate", ignore = true),
    @Mapping(target = "editionDate", ignore = true),
    @Mapping(source = "profileEntity", target = "profile"),
    @Mapping(source = "countryEntity", target = "country"),
    @Mapping(target = "status", ignore = true)
  })
  public ThelephoneEntity mappingThelephoneEntity(
      ThelephoneDTO thelephoneDTO, ProfileEntity profileEntity, CountryEntity countryEntity);

  @AfterMapping
  public default void addDataForThelephoneEntity(@MappingTarget ThelephoneEntity thelephoneEntity) {
    thelephoneEntity.setCreationDate(new Date());
    thelephoneEntity.setStatus(Boolean.TRUE);
  }

  @Mappings({
    @Mapping(source = "thelephoneEntity.telId", target = "telId"),
    @Mapping(source = "thelephoneEntity.creationDate", target = "creationDate"),
    @Mapping(source = "thelephoneDTO.numTel", target = "numTel"),
    @Mapping(source = "countryEntity", target = "country"),
    @Mapping(target = "deleteDate", ignore = true),
    @Mapping(source = "editionDate", target = "editionDate"),
    @Mapping(target = "status", ignore = true)
  })
  public ThelephoneEntity mappingUpdateThelephoneEntity(
      ThelephoneDTO thelephoneDTO,
      ThelephoneEntity thelephoneEntity,
      ProfileEntity profileEntity,
      Date editionDate,
      CountryEntity countryEntity);

  public ThelephoneDTO mappingThelephoneDTO(
      ThelephoneEntity thelephoneEntity, Long countryId, String numPrefAndTel, String prefTel);
}
