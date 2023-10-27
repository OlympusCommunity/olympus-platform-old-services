package com.olympus.platform.service;

import com.olympus.platform.model.UserGetResponseDTO;
import com.olympus.platform.model.UserPostRequestDTO;
import com.olympus.platform.model.UserPostResponseDTO;
import com.olympus.platform.model.UserRequestLoginDTO;
import com.olympus.platform.model.UserResponseLoginDTO;

public interface UserService {

  UserPostResponseDTO createUserService(UserPostRequestDTO userPostRequestDTO);

  UserResponseLoginDTO loginService(UserRequestLoginDTO userRequestLoginDTO);

  UserResponseLoginDTO logoutService(String userId);

  UserGetResponseDTO getUserInformationService(String userId);

  UserResponseLoginDTO changePasswordService(String userId);
}
