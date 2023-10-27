package com.olympus.platform.model;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class CommunityPostRequestDTO {

  @NotNull(message = "cmName " + Constants.MESSAGE_NOT_NULL)
  @NotBlank(message = "cmName " + Constants.MESSAGE_NOT_BLANK)
  @NotEmpty(message = "cmName " + Constants.MESSAGE_NOT_EMPTY)
  private String cmName;

  @NotNull(message = "cmDesc " + Constants.MESSAGE_NOT_NULL)
  @NotBlank(message = "cmDesc " + Constants.MESSAGE_NOT_BLANK)
  @NotEmpty(message = "cmDesc " + Constants.MESSAGE_NOT_EMPTY)
  private String cmDesc;

  @NotNull(message = "cmPhotoPath " + Constants.MESSAGE_NOT_NULL)
  @NotBlank(message = "cmPhotoPath " + Constants.MESSAGE_NOT_BLANK)
  @NotEmpty(message = "cmPhotoPath " + Constants.MESSAGE_NOT_EMPTY)
  private String cmPhotoPath;

  @NotNull(message = "themes " + Constants.MESSAGE_NOT_NULL)
  @Valid
  private List<ThemeCommunityDTO> themes;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private List<Long> roles;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private List<String> profiles;
}
