package com.olympus.platform.service.impl;

import com.olympus.platform.entity.RoleEntity;
import com.olympus.platform.exception.handler.ResourceConflictsException;
import com.olympus.platform.mapper.RoleMapper;
import com.olympus.platform.model.RolePostRequestDTO;
import com.olympus.platform.model.RolePostResponseDTO;
import com.olympus.platform.repository.RoleRepository;
import com.olympus.platform.service.RoleService;
import com.olympus.platform.util.Constants;
import java.util.Date;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class RoleServiceImpl implements RoleService {

  @Autowired private RoleRepository roleRepository;

  @Override
  public RolePostResponseDTO createRoleService(RolePostRequestDTO rolePostRequestDTO) {
    log.info(String.format("createRoleService %s", Constants.START_SERVICE));

    RoleEntity roleSaved = new RoleEntity();
    RoleEntity roleEntity = roleRepository.findByRoleName(rolePostRequestDTO.getRoleName());

    if (roleEntity != null) {
      log.error("This name for the Role already exists.");
      throw new ResourceConflictsException(
          String.format(
              "The Role with name: %s", rolePostRequestDTO.getRoleName(), " already exists."));
    } else {
      roleSaved = roleRepository.save(RoleMapper.INSTANCE.mappingRoleEntity(rolePostRequestDTO));
    }

    log.info(String.format("createRoleService %s", Constants.FINAL_SERVICE));
    return RolePostResponseDTO.builder()
        .roleId(roleSaved.getRoleId())
        .creationDate(new Date())
        .build();
  }
}
