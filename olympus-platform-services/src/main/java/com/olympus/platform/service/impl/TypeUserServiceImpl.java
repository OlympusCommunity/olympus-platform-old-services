package com.olympus.platform.service.impl;

import com.olympus.platform.entity.TypeUserEntity;
import com.olympus.platform.mapper.TypeUserMapper;
import com.olympus.platform.model.TypeUserResponseDTO;
import com.olympus.platform.repository.TypeUserRepository;
import com.olympus.platform.service.TypeUserService;
import com.olympus.platform.util.Constants;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class TypeUserServiceImpl implements TypeUserService {

  @Autowired private TypeUserRepository typeUserRepository;

  @Override
  public List<TypeUserResponseDTO> getListTypeUser() {
    log.info(Constants.START_SERVICE);

    return TypeUserMapper.INSTANCE.listTypeUserEntityconvertToListTypeUserResponseDTO(
        typeUserRepository.findByTypes());
  }

  @Override
  public TypeUserResponseDTO getTypeUser(Long typeUserId) {
    log.info(Constants.START_SERVICE);

    TypeUserEntity typeUserEntityOptional =
        typeUserRepository
            .findById(typeUserId)
            .orElseThrow(
                () ->
                    new EntityNotFoundException(
                        String.format("Type user with code: %s", typeUserId, "%s not found.")));

    return TypeUserMapper.INSTANCE.typeUserEntityconvertToTypeUserResponseDTO(
        typeUserEntityOptional);
  }
}
