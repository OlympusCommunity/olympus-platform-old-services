package com.olympus.platform.mapper;

import com.olympus.platform.entity.CountryEntity;
import com.olympus.platform.entity.SubThemeEntity;
import com.olympus.platform.entity.ThemeEntity;
import com.olympus.platform.model.FilterOptionDTO;
import com.olympus.platform.model.SearchFilterGetResponseDTO;
import com.olympus.platform.model.SubFilterOptionDTO;
import java.util.ArrayList;
import java.util.List;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SearchEngineMapper {

  SearchEngineMapper INSTANCE = Mappers.getMapper(SearchEngineMapper.class);

  SearchFilterGetResponseDTO mappingToSearchFilter(
      String filterCode, String filterTittle, List<FilterOptionDTO> filterOptions);

  @Mapping(target = "subFilters", ignore = true)
  FilterOptionDTO filterOptionMappingToFilters(
      String filterOptionId,
      String filterOptionDesc,
      List<CountryEntity> countries,
      List<ThemeEntity> theme,
      List<SubThemeEntity> subThemes);

  @AfterMapping
  public default void addSubFiltersToFilterOptionDTO(
      @MappingTarget FilterOptionDTO filterOptionDTO,
      List<CountryEntity> countries,
      List<ThemeEntity> theme,
      List<SubThemeEntity> subThemes) {
    List<SubFilterOptionDTO> subFilterOptionListForCountries = new ArrayList<>();

    //		countries.forEach(null);
    //
    //		SubFilterOptionDTO subFilterForCountries = new SubFilterOptionDTO();
    //		subFilterForCountries.setSubFilterOptionId();

    filterOptionDTO.setSubFilters(null);
  }
}
