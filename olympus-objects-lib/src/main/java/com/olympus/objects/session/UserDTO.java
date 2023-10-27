package com.olympus.objects.session;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

  @NotNull(message = "El username no debe ser nulo")
  @NotBlank(message = "El username no debe estar en blanco")
  @NotEmpty(message = "El username no debe estar vacio")
  private String username;

  @NotNull(message = "El email no debe ser nulo")
  @NotBlank(message = "El email no debe estar en blanco")
  @NotEmpty(message = "El email no debe estar vacio")
  @Email(message = "El email no es valido")
  private String email;

  @NotNull(message = "El password no debe ser nulo")
  @NotBlank(message = "El password no debe estar en blanco")
  @NotEmpty(message = "El password no debe estar vacio")
  @Size(max = 100, min = 8)
  private String password;

  @NotNull(message = "El repeatPassword no debe ser nulo")
  @NotBlank(message = "El repeatPassword no debe estar en blanco")
  @NotEmpty(message = "El repeatPassword no debe estar vacio")
  @Size(max = 100, min = 8)
  private String repeatPassword;
  
  @NotNull(message = "El tipo no debe ser nulo")
  @NotBlank(message = "El tipo no debe estar en blanco")
  @NotEmpty(message = "El tipo no debe estar vacio")
  private Long typeId;

}
