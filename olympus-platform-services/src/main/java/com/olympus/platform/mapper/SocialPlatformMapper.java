package com.olympus.platform.mapper;

import com.olympus.platform.entity.CommunityEntity;
import com.olympus.platform.entity.SocialNetworkEntity;
import com.olympus.platform.entity.SocialPlatformEntity;
import com.olympus.platform.model.SocialPtPostRequestDTO;
import java.util.Date;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SocialPlatformMapper {

  SocialPlatformMapper INSTANCE = Mappers.getMapper(SocialPlatformMapper.class);

  @Mappings({
    @Mapping(target = "socialPtClick", ignore = true),
    @Mapping(target = "socialPtView", ignore = true),
    @Mapping(target = "community", source = "communityEntity"),
    @Mapping(target = "fechaCreacion", ignore = true),
    @Mapping(target = "socialNetwork", source = "socialNetworkEntity"),
    @Mapping(target = "socialPtId", ignore = true)
  })
  public SocialPlatformEntity mappingSocialPaltformEntity(
      SocialPtPostRequestDTO socialPtPostRequestDTO,
      CommunityEntity communityEntity,
      SocialNetworkEntity socialNetworkEntity);

  @AfterMapping
  public default void addDefaultDataToSocialPlatformEntity(
      @MappingTarget SocialPlatformEntity socialPlatformEntity) {
    socialPlatformEntity.setFechaCreacion(new Date());
    socialPlatformEntity.setSocialPtClick(0L);
    socialPlatformEntity.setSocialPtView(0L);
  }
}
