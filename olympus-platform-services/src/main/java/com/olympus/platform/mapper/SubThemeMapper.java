package com.olympus.platform.mapper;

import com.olympus.platform.entity.SubThemeEntity;
import com.olympus.platform.entity.ThemeEntity;
import com.olympus.platform.model.SubThemeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubThemeMapper {

  SubThemeMapper INSTANCE = Mappers.getMapper(SubThemeMapper.class);

  @Mapping(target = "subThemeId", ignore = true)
  @Mapping(source = "themeEntity", target = "theme")
  public SubThemeEntity mappingSubThemeEntity(SubThemeDTO subThemeDTO, ThemeEntity themeEntity);
}
