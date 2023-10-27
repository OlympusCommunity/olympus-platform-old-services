package com.olympus.platform.service;

import com.olympus.platform.model.TypeUserResponseDTO;
import java.util.List;

public interface TypeUserService {

  List<TypeUserResponseDTO> getListTypeUser();

  TypeUserResponseDTO getTypeUser(Long typeUserId);
}
