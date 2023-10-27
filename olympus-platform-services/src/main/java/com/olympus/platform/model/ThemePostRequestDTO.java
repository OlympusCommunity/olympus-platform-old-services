package com.olympus.platform.model;

import com.olympus.platform.util.Constants;
import java.util.List;
import javax.validation.Valid;
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
public class ThemePostRequestDTO {

  @NotNull(message = "themeName " + Constants.MESSAGE_NOT_NULL)
  @NotBlank(message = "themeName " + Constants.MESSAGE_NOT_BLANK)
  @NotEmpty(message = "themeName " + Constants.MESSAGE_NOT_EMPTY)
  private String themeName;

  private String themeDesc;

  @NotNull(message = "subThemes " + Constants.MESSAGE_NOT_NULL)
  @NotEmpty(message = "subThemes " + Constants.MESSAGE_NOT_EMPTY)
  @Valid
  private List<SubThemeDTO> subThemes;
}
