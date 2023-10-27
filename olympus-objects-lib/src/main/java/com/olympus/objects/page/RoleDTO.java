package com.olympus.objects.page;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoleDTO {
	
	@NotNull(message = "El roleName no debe ser nulo")
	@NotBlank(message = "El roleName no debe estar en blanco")
	@NotEmpty(message = "El roleName no debe estar vacio")
	private String roleName;
	
	@NotNull(message = "El roleDesc no debe ser nulo")
	@NotBlank(message = "El roleDesc no debe estar en blanco")
	@NotEmpty(message = "El roleDesc no debe estar vacio")
	private String roleDesc;

}
