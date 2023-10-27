package com.olympus.platform.service;

import com.olympus.platform.entity.SecurityKeyEntity;
import com.olympus.platform.entity.UserEntity;
import com.olympus.platform.model.security.SecurityKeyDTO;

public interface SecurityServiceInterface {

    SecurityKeyDTO securityKeyGenerator();

    SecurityKeyDTO getSecurityKeyByUser (String credentials);

    void createSecurityKey (SecurityKeyDTO securityKeyDTO, UserEntity user);

}
