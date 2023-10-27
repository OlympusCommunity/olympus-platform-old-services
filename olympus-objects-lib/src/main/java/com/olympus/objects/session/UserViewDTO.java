package com.olympus.objects.session;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserViewDTO {

	private String userId;
	private String username;
	private String email;
	private TypeUserViewDTO typeUser;
}
