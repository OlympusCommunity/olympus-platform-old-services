package com.olympus.platform.mapper;

import com.olympus.platform.entity.CommunityEntity;
import com.olympus.platform.entity.CommunityThemeEntity;
import com.olympus.platform.entity.SubThemeEntity;
import com.olympus.platform.entity.ThemeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommunityThemeMapper {

  CommunityThemeMapper INSTANCE = Mappers.getMapper(CommunityThemeMapper.class);

  @Mappings({
    @Mapping(target = "comCatId", ignore = true),
    @Mapping(target = "community", source = "community"),
    @Mapping(target = "subTheme", source = "subTheme"),
    @Mapping(target = "theme", source = "theme")
  })
  public CommunityThemeEntity mappingCommunityThemeEntity(
      CommunityEntity community, ThemeEntity theme, SubThemeEntity subTheme);
}
