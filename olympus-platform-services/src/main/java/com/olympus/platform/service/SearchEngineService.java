package com.olympus.platform.service;

import com.olympus.platform.model.SearchFilterGetResponseDTO;
import java.util.List;

public interface SearchEngineService {

  List<SearchFilterGetResponseDTO> getSearchFilters();
}
