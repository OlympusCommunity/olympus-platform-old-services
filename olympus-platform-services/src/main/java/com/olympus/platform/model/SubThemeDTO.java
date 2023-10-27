package com.olympus.platform.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubThemeDTO {

  @NotNull(message = "El themeName no debe ser nulo")
  @NotBlank(message = "El themeName no debe estar en blanco")
  @NotEmpty(message = "El themeName no debe estar vacio")
  private String subThemeName;

  private String subThemeDesc;
}
