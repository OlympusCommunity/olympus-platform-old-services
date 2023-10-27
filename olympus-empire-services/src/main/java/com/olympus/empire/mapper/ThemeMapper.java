package com.olympus.empire.mapper;

import java.util.ArrayList;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.olympus.empire.domain.SubThemeEntity;
import com.olympus.empire.domain.ThemeEntity;
import com.olympus.objects.page.SubThemeDTO;
import com.olympus.objects.page.ThemeDTO;

@Mapper
public interface ThemeMapper {
	
	ThemeMapper INSTANCE = Mappers.getMapper(ThemeMapper.class);
	
	@Mapping(target = "themeDesc", source = "themeName")
	@Mapping(target = "themeId", ignore = true)
	ThemeEntity convertThemeDTO2ThemeEntity (ThemeDTO themeDTO);

	default SubThemeEntity convertSubThemeDTO2SubThemeEntity (SubThemeDTO subThemeDTO, ThemeEntity themeEntity) {
		SubThemeEntity subThemeEntity = new SubThemeEntity();
		subThemeEntity.setSubThemeDesc(subThemeDTO.getSubThemeName());
		subThemeEntity.setTheme(themeEntity);
		return subThemeEntity;
	}
	
	default ThemeDTO getMappedThemeView (List<SubThemeEntity> subThemesEntity, ThemeEntity themeEntity) {
		ThemeDTO themeDTO = new ThemeDTO();
		List<SubThemeDTO> listaSubThemes = new ArrayList<SubThemeDTO>();
		
		themeDTO.setThemeName(themeEntity.getThemeDesc());
		
		for (SubThemeEntity subTheme : subThemesEntity) {
			SubThemeDTO subThemeDTO = new SubThemeDTO();
			subThemeDTO.setSubThemeName(subTheme.getSubThemeDesc());
			listaSubThemes.add(subThemeDTO);
		}
		
		themeDTO.setSubThemes(listaSubThemes);
		return themeDTO;
	}

}
