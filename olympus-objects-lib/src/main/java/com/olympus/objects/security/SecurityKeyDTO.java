package com.olympus.objects.security;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SecurityKeyDTO {

	private String keyPass;

	private String ivKey;

	private String saltKey;

}
