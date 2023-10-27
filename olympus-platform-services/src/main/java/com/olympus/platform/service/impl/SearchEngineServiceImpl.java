package com.olympus.platform.service.impl;

import com.olympus.platform.entity.CountryEntity;
import com.olympus.platform.entity.SubThemeEntity;
import com.olympus.platform.entity.ThemeEntity;
import com.olympus.platform.model.SearchFilterGetResponseDTO;
import com.olympus.platform.repository.CountryRepository;
import com.olympus.platform.repository.SubThemeRepository;
import com.olympus.platform.repository.ThemeRepository;
import com.olympus.platform.service.SearchEngineService;
import com.olympus.platform.util.Constants;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class SearchEngineServiceImpl implements SearchEngineService {

  @Autowired private CountryRepository countryRepository;
  @Autowired private ThemeRepository themeRepository;
  @Autowired private SubThemeRepository subThemeRepository;

  @Override
  public List<SearchFilterGetResponseDTO> getSearchFilters() {
    log.info(String.format("getSearchFilters %s", Constants.START_SERVICE));

    // GET FILTERS FOR COUNTRIES
    List<CountryEntity> countries = countryRepository.findAll();

    // GET FILTERS FOR THEMES
    List<ThemeEntity> themes = themeRepository.findAll();

    // GET FILTERS FOR SUBTHEMES
    List<SubThemeEntity> subThemes = subThemeRepository.findAll();

    log.info(String.format("getSearchFilters %s", Constants.FINAL_SERVICE));
    return null;
  }
}
