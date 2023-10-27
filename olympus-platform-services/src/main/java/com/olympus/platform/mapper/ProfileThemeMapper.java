package com.olympus.platform.mapper;

import com.olympus.platform.entity.ProfileEntity;
import com.olympus.platform.entity.ProfileThemeEntity;
import com.olympus.platform.entity.SubThemeEntity;
import com.olympus.platform.entity.ThemeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProfileThemeMapper {

  ProfileThemeMapper INSTANCE = Mappers.getMapper(ProfileThemeMapper.class);

  @Mapping(target = "profileThemeId", ignore = true)
  @Mapping(target = "subTheme", source = "subTheme")
  public ProfileThemeEntity mappingProfileThemeEntity(
      ProfileEntity profile, ThemeEntity theme, SubThemeEntity subTheme);
}
