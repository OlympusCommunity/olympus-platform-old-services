package com.olympus.platform.mapper;

import com.olympus.platform.entity.CountryEntity;
import com.olympus.platform.entity.ProfileEntity;
import com.olympus.platform.entity.UserEntity;
import com.olympus.platform.model.ProfileGetResponseDTO;
import com.olympus.platform.model.ProfilePostRequestDTO;
import com.olympus.platform.model.ProfilePutRequestDTO;
import com.olympus.platform.model.ThelephoneDTO;
import com.olympus.platform.util.Constants;
import java.util.Date;
import java.util.List;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProfileMapper {

  ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);

  @Mappings({
    @Mapping(target = "profileId", ignore = true),
    @Mapping(target = "profilePhoto", ignore = true),
    @Mapping(source = "userEntity", target = "user"),
    @Mapping(source = "countryEntity", target = "country")
  })
  public ProfileEntity mappingProfileEntity(
      ProfilePostRequestDTO profilePostRequestDTO,
      UserEntity userEntity,
      CountryEntity countryEntity);

  @AfterMapping
  public default void addDataForRegisterProfile(
      @MappingTarget ProfileEntity profileEntity, UserEntity userEntity) {
    profileEntity.setProfileId(Constants.PROFILE_OP_COD + userEntity.getUserId());
    profileEntity.setCreationDate(new Date());
    profileEntity.setStatus(Boolean.TRUE);
  }

  public ProfileGetResponseDTO mappingProfileGetResponseDTO(
      ProfileEntity profileEntity, List<ThelephoneDTO> thelephones);

  @Mappings({
    @Mapping(source = "countryEntity", target = "country"),
    @Mapping(target = "profilePhoto", ignore = true),
    @Mapping(source = "userEntity", target = "user"),
    @Mapping(target = "deleteDate", ignore = true),
  })
  public ProfileEntity updateMappingProfileEntity(
      ProfilePutRequestDTO profilePutRequestDTO,
      UserEntity userEntity,
      CountryEntity countryEntity,
      Date creationDate,
      Date editionDate,
      Boolean status);
}
