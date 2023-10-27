package com.olympus.platform.service;

import com.olympus.platform.entity.UserEntity;
import com.olympus.platform.model.session.UserPostRequestDTO;
import com.olympus.platform.model.session.UserPostResponseDTO;
import com.olympus.platform.model.session.UserPostSigInResponseDTO;
import com.olympus.platform.model.session.UserPostSignInRequestDTO;

public interface UserServiceInterface {

    UserEntity searchUserRegister(UserPostSignInRequestDTO userPostSignInRequestDTO);

    UserPostSigInResponseDTO signInService(UserEntity userPostSignInRequestDTO, String token);

    UserPostResponseDTO createUser(UserPostRequestDTO userPostRequestDTO);

}
