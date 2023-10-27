package com.zycryx.olympus.infrastructure.service;

import com.zycryx.olympus.infrastructure.dto.session.SessionPostSignInRequestDTO;
import com.zycryx.olympus.infrastructure.dto.session.SessionPostSignInResponseDTO;

public interface SessionService {

    SessionPostSignInResponseDTO signInService(SessionPostSignInRequestDTO credentials, String token);

}
