package com.olympus.objects.session;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProfileDTO {

	@NotNull(message = "El nombre no debe ser nulo")
	@NotBlank(message = "El nombre no debe estar en blanco")
	@NotEmpty(message = "El nombre no debe estar vacio")
	private String name;
	
	@NotNull(message = "El apellido no debe ser nulo")
	@NotBlank(message = "El apellido no debe estar en blanco")
	@NotEmpty(message = "El apellido no debe estar vacio")
	private String surname;
	
	@NotNull(message = "El cumpleaños no debe ser nulo")
	@NotBlank(message = "El cumpleaños no debe estar en blanco")
	@NotEmpty(message = "El cumpleaños no debe estar vacio")
	private String birthday;
	
	private String info;
	
	private String alias;
	
	private String nickname;
	
	@NotNull(message = "El pais no debe ser nulo")
	@NotBlank(message = "El pais no debe estar en blanco")
	@NotEmpty(message = "El pais no debe estar vacio")
	private Long country;
	
	@NotNull(message = "La ciudad no debe ser nulo")
	@NotBlank(message = "La ciudad no debe estar en blanco")
	@NotEmpty(message = "La ciudad no debe estar vacio")
	private String city;
	
	@NotNull(message = "El codigo de usuario no debe ser nulo")
	@NotBlank(message = "El codigo de usuario no debe estar en blanco")
	@NotEmpty(message = "El codigo de usuario no debe estar vacio")
	private String userId;
	
	@NotNull(message = "Los telefonos de usuario no debe ser nulo")
	@NotBlank(message = "Los telefonos de usuario no debe estar en blanco")
	@NotEmpty(message = "Los telefonos de usuario no debe estar vacio")
	private List<TelephoneDTO> telephones;
	
}
