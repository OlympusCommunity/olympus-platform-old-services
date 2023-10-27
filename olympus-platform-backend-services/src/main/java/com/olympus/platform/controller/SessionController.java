package com.olympus.platform.controller;

import com.olympus.platform.model.audit.AuditRequestDTO;
import com.olympus.platform.model.audit.AuditResponseDTO;
import com.olympus.platform.model.session.UserPostRequestDTO;
import com.olympus.platform.model.session.UserPostResponseDTO;
import com.olympus.platform.model.session.UserPostSigInResponseDTO;
import com.olympus.platform.model.session.UserPostSignInRequestDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

@Api(value = "session", tags = {"Session Controller"})
@RequestMapping(value = "/api/principal/v1/session", produces = MediaType.APPLICATION_JSON_VALUE)
public interface SessionController {

    /**
     * Session Login User
     *
     * @return UserPostSigInResponseDTO
     */
    @ApiOperation(
            value = "Session Login User"
    )
    @ApiResponses({
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 503, message = "Service Unavailable")
    })
    @PostMapping(
            value = "/sign-in",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<UserPostSigInResponseDTO> sessionLoginController (@Valid @RequestBody UserPostSignInRequestDTO userPostSignInRequestDTO) throws Exception;

    /**
     * Register User by credentials and generate security credentials
     *
     * @return UserPostResponseDTO
     */
    @ApiOperation(
            value = "Register User by credentials and generate security credentials"
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 503, message = "Service Unavailable")
    })
    @PostMapping(
            value = "/sign-up",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<UserPostResponseDTO> sessionRegisterController (@Valid @RequestBody UserPostRequestDTO userPostRequestDTO);

    /**
     * Audit logout session
     *
     * @return AuditResponseDTO
     */
    @ApiOperation(
            value = "Audit logout session"
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 503, message = "Service Unavailable")
    })
    @PostMapping(
            value = "/logout",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<AuditResponseDTO> sessionRegisterController (@Valid @RequestBody AuditRequestDTO auditRequestDTO);

}
