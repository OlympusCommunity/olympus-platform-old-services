package com.olympus.platform.model.session;

import com.olympus.platform.model.other.AuditSingInDTO;
import com.olympus.platform.model.other.TokenResponseDTO;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UserPostSigInResponseDTO {
    private String message;
    private AuditSingInDTO info;
    private TokenResponseDTO token;
}
