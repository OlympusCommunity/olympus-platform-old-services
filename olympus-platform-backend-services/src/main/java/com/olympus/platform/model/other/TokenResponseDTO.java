package com.olympus.platform.model.other;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TokenResponseDTO {
    private String token;
    private String refreshToken;
}
