package com.olympus.platform.model.security;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class SecurityKeyDTO {

    private String keyPass;
    private String ivKey;
    private String saltKey;

}
