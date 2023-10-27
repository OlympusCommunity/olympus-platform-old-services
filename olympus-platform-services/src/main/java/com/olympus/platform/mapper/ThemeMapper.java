package com.olympus.platform.mapper;

import com.olympus.platform.entity.ThemeEntity;
import com.olympus.platform.model.ThemePostRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ThemeMapper {

  ThemeMapper INSTANCE = Mappers.getMapper(ThemeMapper.class);

  @Mapping(target = "themeId", ignore = true)
  public ThemeEntity mappingThemeEntity(ThemePostRequestDTO themePostRequestDTO);
}
