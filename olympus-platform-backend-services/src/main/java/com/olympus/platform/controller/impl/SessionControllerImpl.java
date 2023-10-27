package com.olympus.platform.controller.impl;

import com.olympus.platform.controller.SessionController;
import com.olympus.platform.entity.UserEntity;
import com.olympus.platform.model.audit.AuditRequestDTO;
import com.olympus.platform.model.audit.AuditResponseDTO;
import com.olympus.platform.model.session.UserPostRequestDTO;
import com.olympus.platform.model.session.UserPostResponseDTO;
import com.olympus.platform.model.session.UserPostSigInResponseDTO;
import com.olympus.platform.model.session.UserPostSignInRequestDTO;
import com.olympus.platform.security.jwt.JwtTokenUtil;
import com.olympus.platform.service.AuditServiceInterface;
import com.olympus.platform.service.UserServiceInterface;
import com.olympus.platform.service.impl.AuthenticationService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@AllArgsConstructor
public class SessionControllerImpl implements SessionController {

    private final UserServiceInterface userService;
    private final AuditServiceInterface auditServiceInterface;
    @Autowired
    private final DaoAuthenticationProvider daoAuthenticationProvider;
    private final AuthenticationService authenticationService;
    private final JwtTokenUtil jwtTokenUtil;

    /**
     * Session Login User
     *
     * @return Void
     */
    @Override
    public ResponseEntity<UserPostSigInResponseDTO> sessionLoginController(UserPostSignInRequestDTO userPostSignInRequestDTO) throws Exception {
        UserEntity user = userService.searchUserRegister(userPostSignInRequestDTO);
        UserDetails userDetails = authenticationService.loadUserByUsername(user.getUserName());

        try {
            daoAuthenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        return ResponseEntity.ok(userService.signInService(user, jwtTokenUtil.generateToken(userDetails)));
    }

    /**
     * Register User by credentials and generate security credentials
     *
     * @param userPostRequestDTO
     * @return UserPostResponseDTO
     */
    @Override
    public ResponseEntity<UserPostResponseDTO> sessionRegisterController(UserPostRequestDTO userPostRequestDTO) {
        return ResponseEntity.ok(userService.createUser(userPostRequestDTO));
    }

    /**
     * Audit logout session
     *
     * @param auditRequestDTO
     * @return AuditResponseDTO
     */
    @Override
    public ResponseEntity<AuditResponseDTO> sessionRegisterController(AuditRequestDTO auditRequestDTO) {
        return ResponseEntity.ok(auditServiceInterface.auditRegisterService(auditRequestDTO));
    }
}
