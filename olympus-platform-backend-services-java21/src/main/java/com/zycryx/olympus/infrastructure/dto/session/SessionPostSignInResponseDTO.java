package com.zycryx.olympus.infrastructure.dto.session;

import com.zycryx.olympus.infrastructure.dto.audit.AuditSingInDTO;
import com.zycryx.olympus.infrastructure.dto.security.TokenResponseDTO;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class SessionPostSignInResponseDTO {

    private String message;
    private AuditSingInDTO info;
    private TokenResponseDTO token;
}
