package com.olympus.platform.service;

import com.olympus.platform.model.ThemePostRequestDTO;
import com.olympus.platform.model.ThemePostResponseDTO;

public interface ThemeService {

  ThemePostResponseDTO createThemeAndSubthemesService(
      ThemePostRequestDTO themePostRequestDTO);
}
