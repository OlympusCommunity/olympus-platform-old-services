package com.olympus.objects.page;

import java.util.List;
import javax.validation.Valid;
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
public class CommunityDTO {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String communityId;

	@NotNull(message = "El cmName no debe ser nulo")
	@NotBlank(message = "El cmName no debe estar en blanco")
	@NotEmpty(message = "El cmName no debe estar vacio")
	private String cmName;

	@NotNull(message = "El cmDesc no debe ser nulo")
	@NotBlank(message = "El cmDesc no debe estar en blanco")
	@NotEmpty(message = "El cmDesc no debe estar vacio")
	private String cmDesc;

	@NotNull(message = "El themes no debe ser nulo")
	@NotBlank(message = "El themes no debe estar en blanco")
	@NotEmpty(message = "El themes no debe estar vacio")
	@Valid
	private List<ThemeCommunityDTO> themes;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<Long> roles;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<String> profiles;

}
