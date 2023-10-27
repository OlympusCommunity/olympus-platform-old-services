package com.olympus.platform.service.impl;

import com.olympus.platform.entity.ActionAuditEntity;
import com.olympus.platform.entity.SecurityKeysEntity;
import com.olympus.platform.entity.TypeUserEntity;
import com.olympus.platform.entity.UserEntity;
import com.olympus.platform.enums.ActionAuditEnum;
import com.olympus.platform.exception.handler.OlympusBusinessException;
import com.olympus.platform.exception.handler.ResourceConflictsException;
import com.olympus.platform.exception.handler.ResourceValidationException;
import com.olympus.platform.mapper.AuditMapper;
import com.olympus.platform.mapper.SecurityKeysMapper;
import com.olympus.platform.mapper.UserMapper;
import com.olympus.platform.model.AuditDTO;
import com.olympus.platform.model.SecurityKeyDTO;
import com.olympus.platform.model.UserGetResponseDTO;
import com.olympus.platform.model.UserPostRequestDTO;
import com.olympus.platform.model.UserPostResponseDTO;
import com.olympus.platform.model.UserRequestLoginDTO;
import com.olympus.platform.model.UserResponseLoginDTO;
import com.olympus.platform.repository.ActionAuditRespository;
import com.olympus.platform.repository.AuditRepository;
import com.olympus.platform.repository.SecurityKeyRepository;
import com.olympus.platform.repository.TypeUserRepository;
import com.olympus.platform.repository.UserRepository;
import com.olympus.platform.service.UserService;
import com.olympus.platform.util.Constants;
import com.olympus.platform.util.UtilEncrypting;
import com.olympus.platform.util.UtilValidation;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class UserServiceImpl implements UserService {

  @Autowired private UserRepository userRepository;
  @Autowired private TypeUserRepository typeUserRepository;
  @Autowired private SecurityKeyRepository securityKeyRepository;
  @Autowired private AuditRepository auditRepository;
  @Autowired private ActionAuditRespository actionAuditRespository;

  @Override
  public UserPostResponseDTO createUserService(UserPostRequestDTO userPostRequestDTO) {
    log.info(String.format("createUserService %s", Constants.START_SERVICE));

    List<TypeUserEntity> typeUserList =
        typeUserRepository.findAllById(userPostRequestDTO.getTypesIds());
    UserEntity userEntity = null;

    if (userPostRequestDTO.getPassword().isBlank()
        || !userPostRequestDTO.getPassword().equals(userPostRequestDTO.getRepeatPassword())) {
      log.error("Error, The entered passwords do not match. Try again.");
      throw new ResourceValidationException("The entered passwords do not match. Try again.");
    } else if (UtilValidation.isNull(
        userRepository.findByUsername(userPostRequestDTO.getUsername()))) {
      updateTypeUserLimits(typeUserList);
      UtilEncrypting utilEncrypting = new UtilEncrypting();
      SecurityKeyDTO securityKeyDTO = generateSecurityKeys();
      userPostRequestDTO.setPassword(
          utilEncrypting.aesEncript(userPostRequestDTO.getPassword(), securityKeyDTO));

      userEntity =
          userRepository.save(
              UserMapper.INSTANCE.mappingUserEntity(
                  userPostRequestDTO,
                  idGenerator(validMultiUserTypes(typeUserList), userPostRequestDTO.getUsername()),
                  typeUserList));

      securityKeyRepository.save(
          SecurityKeysMapper.INSTANCE.convertSecurityKeyDTOForSecurityKeysEntity(
              securityKeyDTO, userEntity));

      log.debug("The user was successfully registered.");
      log.info(String.format("createUserService %s", Constants.FINAL_SERVICE));
    } else {
      log.error(
          String.format(
              "Error, %s",
              "Error, A conflict occurred while registering the username: %s",
              userPostRequestDTO.getUsername()));
      throw new ResourceConflictsException("A conflict occurred while registering new user.");
    }
    return UserPostResponseDTO.builder()
        .userId(userEntity.getUserId())
        .creationDate(userEntity.getCreationDate())
        .build();
  }

  @Override
  public UserResponseLoginDTO loginService(UserRequestLoginDTO userRequestLoginDTO) {
    log.info(String.format("loginService %s", Constants.START_SERVICE));
    UtilEncrypting utilEncrypting = new UtilEncrypting();
    AuditDTO auditDTO = new AuditDTO();
    UserEntity userEntity = new UserEntity();

    UserEntity userWithEmailorUsername =
        userRepository.findByUsernameOrEmail(userRequestLoginDTO.getUsernameOrEmail());

    if (userWithEmailorUsername == null) {
      log.error("createUserService. Service Conflict. - Exception: ");
      throw new OlympusBusinessException("Service conflict.");
    } else {
      List<SecurityKeysEntity> securityKeysList =
          securityKeyRepository.findByUser(userWithEmailorUsername);

      userEntity =
          userRepository.findByUsernameOrEmailAndPassword(
              userRequestLoginDTO.getUsernameOrEmail(),
              utilEncrypting.aesEncript(
                  userRequestLoginDTO.getPassword(),
                  SecurityKeysMapper.INSTANCE.convertSecurityEntityKeyForSecurityKeyDTO(
                      securityKeysList.get(0))));

      if (userEntity == null) {
        log.error("createUserService. Service Conflict. - Exception: ");
        throw new OlympusBusinessException("Service conflict.");
      } else {
        auditDTO =
            AuditMapper.INSTANCE.mappingBinnacleDTO(
                auditRepository.save(
                    AuditMapper.INSTANCE.mappingBinnacleEntityWithParameters(
                        userEntity,
                        null,
                        Constants.USER_LOGGED_REASON,
                        getActions(ActionAuditEnum.LOGIN.getActionId()),
                        null)));
      }
    }

    return UserMapper.INSTANCE.mappingUserResponseLoginDTO(userEntity.getUserId(), auditDTO);
  }

  @Override
  public UserResponseLoginDTO logoutService(String userId) {
    log.info(String.format("logoutService %s", Constants.START_SERVICE));
    AuditDTO auditDTO = new AuditDTO();

    UserEntity userEntity =
        userRepository
            .findById(userId)
            .orElseThrow(
                () ->
                    new EntityNotFoundException(
                        String.format("User with userId: %s", userId, " not found.")));

    if (userEntity == null) {
      log.error("logoutService. Service Conflict. - Exception: ");
      throw new OlympusBusinessException("Service conflict. User Entity not found.");
    } else {
      auditDTO =
          AuditMapper.INSTANCE.mappingBinnacleDTO(
              auditRepository.save(
                  AuditMapper.INSTANCE.mappingBinnacleEntityWithParameters(
                      userEntity,
                      null,
                      Constants.USER_LOGOUT_REASON,
                      getActions(ActionAuditEnum.LOGOUT.getActionId()),
                      null)));
    }

    log.info(String.format("logoutService %s", Constants.FINAL_SERVICE));
    return UserMapper.INSTANCE.mappingUserResponseLoginDTO(userEntity.getUserId(), auditDTO);
  }

  @Override
  public UserGetResponseDTO getUserInformationService(String userId) {
    log.info(String.format("getUserInformationService %s", Constants.START_SERVICE));

    UserEntity userEntity =
        userRepository
            .findById(userId)
            .orElseThrow(
                () ->
                    new EntityNotFoundException(
                        String.format("User with userId: %s", userId, " not found.")));

    List<Long> userTypesIds = new ArrayList<Long>();
    userEntity
        .getUserTypes()
        .forEach((TypeUserEntity type) -> userTypesIds.add(type.getTypeUserId()));
    List<TypeUserEntity> userTypes = typeUserRepository.findAllById(userTypesIds);

    log.info(String.format("getUserInformationService %s", Constants.FINAL_SERVICE));
    return UserMapper.INSTANCE.mappingUserGetResponseDTO(userEntity, userTypes);
  }

  @Override
  public UserResponseLoginDTO changePasswordService(String userId) {
    return null;
  }

  private void updateTypeUserLimits(List<TypeUserEntity> typeUserList) {
    typeUserList.forEach(
        (TypeUserEntity type) -> {
          if (type.getTypeUserNumLimit() == Constants.INT_0) {
            log.error(String.format("There are no users available for %s", type, " user type."));
            throw new EntityNotFoundException(
                String.format("There are no users available for %s", type, " user type."));
          } else {
            type.setTypeUserNumLimit(type.getTypeUserNumLimit() - 1);
            typeUserRepository.save(type);
          }
        });
  }

  private String validMultiUserTypes(List<TypeUserEntity> typeUserList) {
    if (typeUserList.isEmpty()) {
      log.error("Error, User types not found in the database.");
      throw new EntityNotFoundException("User types not found in the database.");
    } else if (typeUserList.size() == Constants.INT_1) {
      return typeUserList.get(0).getTypeUserAbv();
    } else {
      return Constants.MULTIUSERTYPE;
    }
  }

  private String idGenerator(String aliasType, String username) {
    log.info("Generar un codigo de usuario");

    String idGenerated =
        aliasType.toUpperCase().substring(0, 2)
            + username.toUpperCase().substring(0, 2)
            + UUID.randomUUID().toString().toUpperCase().substring(0, 21);

    Optional<UserEntity> userEntity = userRepository.findById(idGenerated);

    if (userEntity.isEmpty()) {
      return idGenerated;
    } else {
      return idGenerator(aliasType, username);
    }
  }

  private SecurityKeyDTO generateSecurityKeys() {
    log.info("Generar codigos de seguridad");

    String keyPass = RandomStringUtils.randomAlphanumeric(Constants.LONG_SECURITY_KEYS_32);
    String ivKey = RandomStringUtils.randomAlphanumeric(Constants.LONG_SECURITY_KEYS_16);
    String saltKey = RandomStringUtils.randomAlphanumeric(Constants.LONG_SECURITY_KEYS_32);

    SecurityKeyDTO securityKeyDTO =
        SecurityKeysMapper.INSTANCE.mappingSecurityKeyDTO(keyPass, ivKey, saltKey);

    SecurityKeysEntity securityKeyEntity =
        securityKeyRepository.findByKeyPassAndIvKeyAndSaltKey(
            securityKeyDTO.getKeyPass(), securityKeyDTO.getIvKey(), securityKeyDTO.getSaltKey());

    if (null == securityKeyEntity) {
      return securityKeyDTO;
    } else {
      return generateSecurityKeys();
    }
  }

  private ActionAuditEntity getActions(Long actionId) {
    return actionAuditRespository
        .findById(actionId)
        .orElseThrow(() -> new EntityNotFoundException("Action not found in the database."));
  }
}
