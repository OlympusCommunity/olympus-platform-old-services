package com.olympus.platform.service.impl;

import com.olympus.platform.constants.ValidationConstant;
import com.olympus.platform.entity.SecurityKeyEntity;
import com.olympus.platform.entity.UserEntity;
import com.olympus.platform.mapper.SecurityKeyMapper;
import com.olympus.platform.model.security.SecurityKeyDTO;
import com.olympus.platform.repository.SecurityKeyRepository;
import com.olympus.platform.service.SecurityServiceInterface;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;

@Service
@Log4j2
@AllArgsConstructor
public class SecurityServiceImpl implements SecurityServiceInterface {

    private final SecurityKeyRepository securityKeyRepository;

    /**
     * @return
     */
    @Override
    public SecurityKeyDTO securityKeyGenerator() {
        log.info("Generate security codes.");

        String keyPass = RandomStringUtils.randomAlphanumeric(ValidationConstant.LONG_SECURITY_KEYS_32);
        String ivKey = RandomStringUtils.randomAlphanumeric(ValidationConstant.LONG_SECURITY_KEYS_16);
        String saltKey = RandomStringUtils.randomAlphanumeric(ValidationConstant.LONG_SECURITY_KEYS_32);

        SecurityKeyDTO securityKeyDTO =
                SecurityKeyMapper.INSTANCE.mappingSecurityKeyDTO(keyPass, ivKey, saltKey);

        SecurityKeyEntity securityKeyEntity =
                securityKeyRepository.findByKeyPassAndIvKeyAndSaltKey(
                        securityKeyDTO.getKeyPass(), securityKeyDTO.getIvKey(), securityKeyDTO.getSaltKey());

        if (null == securityKeyEntity) {
            return securityKeyDTO;
        } else {
            return securityKeyGenerator();
        }
    }

    /**
     * @param credentials
     * @return
     */
    @Override
    public SecurityKeyDTO getSecurityKeyByUser(String credentials) {
        return SecurityKeyMapper.INSTANCE.convertSecurityEntityKeyForSecurityKeyDTO(securityKeyRepository.findByUserNameOrEmail(credentials).orElseThrow(() -> new EntityNotFoundException("Security Credentials not found.")));
    }

    /**
     * @param securityKeyDTO
     * @param user
     */
    @Override
    public void createSecurityKey(SecurityKeyDTO securityKeyDTO, UserEntity user) {
        securityKeyRepository.save(SecurityKeyMapper.INSTANCE.convertSecurityKeyDTOForSecurityKeysEntity(securityKeyDTO, user));
    }
}
