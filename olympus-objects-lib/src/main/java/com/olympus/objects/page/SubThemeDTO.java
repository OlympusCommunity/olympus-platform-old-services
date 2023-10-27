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
public class SubThemeDTO {
	
	@NotNull(message = "El themeName no debe ser nulo")
	@NotBlank(message = "El themeName no debe estar en blanco")
	@NotEmpty(message = "El themeName no debe estar vacio")
	private String subThemeName;

}
