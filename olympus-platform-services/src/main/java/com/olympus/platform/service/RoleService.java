package com.olympus.platform.service;

import com.olympus.platform.model.RolePostRequestDTO;
import com.olympus.platform.model.RolePostResponseDTO;

public interface RoleService {

  RolePostResponseDTO createRoleService(RolePostRequestDTO rolePostRequestDTO);
}
