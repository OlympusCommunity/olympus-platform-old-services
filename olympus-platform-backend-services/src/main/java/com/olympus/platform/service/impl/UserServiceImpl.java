package com.olympus.platform.service.impl;

import com.olympus.platform.constants.ValidationConstant;
import com.olympus.platform.entity.CountryEntity;
import com.olympus.platform.entity.UserEntity;
import com.olympus.platform.entity.UserRoleEntity;
import com.olympus.platform.enums.ActionAuditEnum;
import com.olympus.platform.exception.handler.ResourceConflictsException;
import com.olympus.platform.exception.handler.ResourceValidationException;
import com.olympus.platform.mapper.AuditMapper;
import com.olympus.platform.mapper.RolesForUserMapper;
import com.olympus.platform.mapper.UserMapper;
import com.olympus.platform.model.other.AuditSingInDTO;
import com.olympus.platform.model.other.TokenResponseDTO;
import com.olympus.platform.model.session.UserPostRequestDTO;
import com.olympus.platform.model.session.UserPostResponseDTO;
import com.olympus.platform.model.session.UserPostSigInResponseDTO;
import com.olympus.platform.model.session.UserPostSignInRequestDTO;
import com.olympus.platform.repository.*;
import com.olympus.platform.service.AuditServiceInterface;
import com.olympus.platform.service.UserServiceInterface;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import static com.olympus.platform.constants.MessageConstant.SIGN_IN_REASON;
import static com.olympus.platform.constants.MessageConstant.SIGN_UP_REASON;

@Service
@Log4j2
@AllArgsConstructor
public class UserServiceImpl implements UserServiceInterface {

    private final UserRepository userRepository;
    private final RoleForUserRepository roleForUserRepository;
    private final UserRoleRepository userRoleRepository;
    private final AuditRepository auditRepository;
    private final CountryRepository countryRepository;
    private final AuditServiceInterface auditServiceInterface;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    /**
     * @param userPostSignInRequestDTO
     * @return
     */
    @Override
    public UserEntity searchUserRegister(UserPostSignInRequestDTO userPostSignInRequestDTO) {
        return userRepository.findByUserNameOrEmailAndPassword(userPostSignInRequestDTO.getUsernameOrEmail(), passwordEncoder.encode(userPostSignInRequestDTO.getPassword()))
                .orElseThrow(() -> new EntityNotFoundException("User not found with username " + userPostSignInRequestDTO.getUsernameOrEmail()));
    }

    /**
     * @param userEntity
     * @return
     */
    @Override
    public UserPostSigInResponseDTO signInService(UserEntity userEntity, String token) {
        auditSession(userEntity, ActionAuditEnum.LOGIN, SIGN_IN_REASON);
        return UserPostSigInResponseDTO
                .builder()
                .message("Welcome to the system")
                .info(
                        AuditSingInDTO.builder().userId(userEntity.getUserId()).reason(SIGN_IN_REASON).date(new Date()).build())
                .token(TokenResponseDTO.builder().token(token).refreshToken(null).build())
                .build();
    }

    /**
     * @param userPostRequestDTO
     * @return
     */
    @Override
    public UserPostResponseDTO createUser(UserPostRequestDTO userPostRequestDTO) {
        log.info("createUser");

        validPassword(userPostRequestDTO);

        userPostRequestDTO.setPassword(passwordEncoder.encode(userPostRequestDTO.getPassword()));

        if (userRepository.findByUserName(userPostRequestDTO.getUsername()).isPresent()) {
            log.error(ValidationConstant.USER_ALREADY_EXISTS);
            throw new ResourceConflictsException(ValidationConstant.USER_ALREADY_EXISTS);
        }
        List<UserRoleEntity> roles = userRoleRepository.findAllById(userPostRequestDTO.getTypesIds());

        if (roles.isEmpty()) {
            log.error(ValidationConstant.ROLE_NOT_FOUND);
            throw new BadCredentialsException(ValidationConstant.ROLE_NOT_FOUND);
        }

        CountryEntity country =  countryRepository.findById(userPostRequestDTO.getCountryId()).orElseThrow(() -> new EntityNotFoundException("Country not found."));
        UserEntity userSaved = userRepository.save(UserMapper.INSTANCE.mappingCreateUserEntity(userPostRequestDTO, country, userIdGenerator(validMultiUserTypes(roles), userPostRequestDTO.getUsername()), roles));
        log.debug("The user was successfully registered.");

        roles.forEach(role -> {
            if (role.getUserRoleLimit() == ValidationConstant.INT_0) {
                userRepository.delete(userSaved);
                log.error(String.format("There are no users available for %s, %s", role, " user type."));
                throw new EntityNotFoundException(
                        String.format("There are no users available for %s, %s", role, " user type."));
            } else {
                roleForUserRepository.save(RolesForUserMapper.INSTANCE.mappingAssignedRolesForUser(role, userSaved));
                role.setUserRoleLimit(role.getUserRoleLimit() - 1);
                userRoleRepository.save(role);
                log.debug(ValidationConstant.ROLE_UPDATE);
            }
        });
        log.debug("The security credentials was successfully registered.");
        auditSession(userSaved, ActionAuditEnum.CREATE, SIGN_UP_REASON);
        log.info(String.format("createUserService %s", ValidationConstant.FINAL_SERVICE));
        return UserPostResponseDTO.builder()
                .userId(userSaved.getUserId())
                .creationDate(userSaved.getCreationDate())
                .build();
    }

    /**
     * @param userPostRequestDTO
     * @return
     */
    public void validPassword(UserPostRequestDTO userPostRequestDTO) {

        if (!userPostRequestDTO.getPassword().equals(userPostRequestDTO.getRepeatPassword())) {
            log.error(ValidationConstant.PASSWORD_REPEAT);
            throw new ResourceValidationException(ValidationConstant.PASSWORD_REPEAT);
        }

        if (userPostRequestDTO.getPassword().isBlank() || userPostRequestDTO.getRepeatPassword().isBlank()) {
            log.error(ValidationConstant.PASSWORD_NOT_FOUND);
            throw new ResourceValidationException(ValidationConstant.PASSWORD_NOT_FOUND);
        }

        if (userPostRequestDTO.getPassword().equals(ValidationConstant.FIRTS_NUMBERS)
                || userPostRequestDTO.getPassword().equals(ValidationConstant.FIRTS_NUMBERS1)
                || userPostRequestDTO.getPassword().equals(ValidationConstant.ABC)
                || userPostRequestDTO.getPassword().equals(ValidationConstant.ZEROS)) {
            log.error(ValidationConstant.PASSWORD_INCORRECT);
            throw new ResourceValidationException(ValidationConstant.PASSWORD_INCORRECT);
        }

    }

    private String validMultiUserTypes (List<UserRoleEntity> roles) {
        if (roles.isEmpty()) {
            log.error(ValidationConstant.USER_TYPE_NOT_FOUND);
            throw new EntityNotFoundException(ValidationConstant.USER_TYPE_NOT_FOUND);
        } else if (roles.size() == ValidationConstant.INT_1) {
            return roles.get(0).getUserRoleName().substring(0,2);
        } else {
            return ValidationConstant.MULTIUSERTYPE;
        }
    }

    private String userIdGenerator (String aliasUserRole, String username) {
        log.info("Generate userId.");

        String idGenerated =
                aliasUserRole.toUpperCase() + username.toUpperCase().substring(0, 2) + UUID.randomUUID().toString().toUpperCase().substring(0, 21);
        Optional<UserEntity> userEntity = userRepository.findById(idGenerated);

        if (userEntity.isEmpty()) {
            return idGenerated;
        } else {
            return userIdGenerator(aliasUserRole, username);
        }
    }

    private void auditSession (UserEntity user, ActionAuditEnum actionDesc, String reason) {
        log.info("Audit login.");
        auditRepository.save(AuditMapper.INSTANCE.mappingAuditEntity(user, actionDesc, "Opera GX", "192.168.102.43", reason, new Date()));
    }

}
