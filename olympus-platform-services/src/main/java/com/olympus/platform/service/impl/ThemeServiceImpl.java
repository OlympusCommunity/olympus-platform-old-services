package com.olympus.platform.service.impl;

import com.olympus.platform.entity.ThemeEntity;
import com.olympus.platform.exception.handler.ResourceConflictsException;
import com.olympus.platform.mapper.SubThemeMapper;
import com.olympus.platform.mapper.ThemeMapper;
import com.olympus.platform.model.SubThemeDTO;
import com.olympus.platform.model.ThemePostRequestDTO;
import com.olympus.platform.model.ThemePostResponseDTO;
import com.olympus.platform.repository.SubThemeRepository;
import com.olympus.platform.repository.ThemeRepository;
import com.olympus.platform.service.ThemeService;
import com.olympus.platform.util.Constants;
import java.util.Date;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ThemeServiceImpl implements ThemeService {

  @Autowired private ThemeRepository themeRepository;

  @Autowired private SubThemeRepository subThemeRepository;

  @Override
  public ThemePostResponseDTO createThemeAndSubthemesService(
      ThemePostRequestDTO themePostRequestDTO) {
    log.info(String.format("createThemeAndSubthemesService %s", Constants.START_SERVICE));

    ThemeEntity themeEntity = themeRepository.findByThemeName(themePostRequestDTO.getThemeName());

    if (themeEntity != null) {
      log.error("This name for the profile already exists.");
      throw new ResourceConflictsException(
          String.format("The name: %s", themePostRequestDTO.getThemeName(), " already exists."));
    }

    ThemeEntity themeSaved =
        themeRepository.save(ThemeMapper.INSTANCE.mappingThemeEntity(themePostRequestDTO));

    for (SubThemeDTO subTheme : themePostRequestDTO.getSubThemes()) {
      subThemeRepository.save(SubThemeMapper.INSTANCE.mappingSubThemeEntity(subTheme, themeSaved));
    }

    log.info(String.format("createThemeAndSubthemesService %s", Constants.FINAL_SERVICE));
    return ThemePostResponseDTO.builder()
        .themeId(themeSaved.getThemeId())
        .creationDate(new Date())
        .build();
  }
}
