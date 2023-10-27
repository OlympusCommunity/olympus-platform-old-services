package com.olympus.objects.page;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ThemeDTO {
	
	@NotNull(message = "El themeName no debe ser nulo")
	@NotBlank(message = "El themeName no debe estar en blanco")
	@NotEmpty(message = "El themeName no debe estar vacio")
	private String themeName;
	
	@NotNull(message = "El subThemes no debe ser nulo")
	@NotBlank(message = "El subThemes no debe estar en blanco")
	@NotEmpty(message = "El subThemes no debe estar vacio")
	@Valid
	private List<SubThemeDTO> subThemes;

}
