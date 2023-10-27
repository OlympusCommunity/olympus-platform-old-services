package com.olympus.objects.security;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SecurityKeySavedDTO {

	@NotNull(message = "El keyPass no debe ser nulo")
	@NotBlank(message = "El keyPass no debe estar en blanco")
	@NotEmpty(message = "El keyPass no debe estar vacio")
	private String keyPass;
	
	@NotNull(message = "El ivKey no debe ser nulo")
	@NotBlank(message = "El ivKey no debe estar en blanco")
	@NotEmpty(message = "El ivKey no debe estar vacio")
	private String ivKey;
	
	@NotNull(message = "El saltKey no debe ser nulo")
	@NotBlank(message = "El saltKey no debe estar en blanco")
	@NotEmpty(message = "El saltKey no debe estar vacio")
	private String saltKey;

}
