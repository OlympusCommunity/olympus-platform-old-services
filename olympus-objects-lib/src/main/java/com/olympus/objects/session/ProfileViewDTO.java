package com.olympus.objects.session;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.olympus.objects.page.RoleDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProfileViewDTO {
	
	private String name;
	
	private String surname;
	
	private String nickname;

	private String birthday;
	
	private String info;
	
	private String alias;

	private String country;

	private String city;
	
	private String createAt;
	
	private String updateAt;

	private UserViewDTO user;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<RoleDTO> roles;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<TelephoneDTO> telephones;

}
