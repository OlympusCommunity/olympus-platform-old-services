package com.zycryx.olympus.infrastructure.service.impl;

import com.zycryx.olympus.domain.session.UserSession;
import com.zycryx.olympus.infrastructure.dto.audit.AuditSingInDTO;
import com.zycryx.olympus.infrastructure.dto.security.TokenResponseDTO;
import com.zycryx.olympus.infrastructure.dto.session.SessionPostSignInRequestDTO;
import com.zycryx.olympus.infrastructure.dto.session.SessionPostSignInResponseDTO;
import com.zycryx.olympus.infrastructure.repository.UserRepository;
import com.zycryx.olympus.infrastructure.service.SessionService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import java.util.Date;
import static com.zycryx.olympus.util.constants.MessageConstant.SIGN_IN_REASON;

@Service
@Log4j2
@AllArgsConstructor
public class SessionServiceImpl implements SessionService {

    private final UserRepository userRepository;

    /**
     * @param credentials
     * @param token
     * @return
     */
    @Override
    public SessionPostSignInResponseDTO signInService(SessionPostSignInRequestDTO credentials, String token) {
        UserSession userSession = userRepository.findByUsernameOrEmailAndPassword(credentials.getUsernameOrEmail(), credentials.getUsernameOrEmail(), credentials.getPassword())
                .orElseThrow(() -> new EntityNotFoundException("User not found with username " + credentials.getUsernameOrEmail()));
        //auditSession(userEntity, ActionAuditEnum.LOGIN, SIGN_IN_REASON);
        return SessionPostSignInResponseDTO
                .builder()
                .message("Welcome to the system")
                .info(
                        AuditSingInDTO.builder().userId(userSession.getId()).reason(SIGN_IN_REASON).date(new Date()).build())
                .token(TokenResponseDTO.builder().token(token).refreshToken(null).build())
                .build();
    }

}
