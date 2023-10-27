package com.olympus.objects.session;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TelephoneDTO {
	
	@NotNull(message = "El country no debe ser nulo")
	@NotBlank(message = "El country no debe estar en blanco")
	@NotEmpty(message = "El country no debe estar vacio")
	private Long country;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String countryName;

	@NotNull(message = "El numTel no debe ser nulo")
	@NotBlank(message = "El numTel no debe estar en blanco")
	@NotEmpty(message = "El numTel no debe estar vacio")
	private String numTel;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String numPrefAndTel;

}
