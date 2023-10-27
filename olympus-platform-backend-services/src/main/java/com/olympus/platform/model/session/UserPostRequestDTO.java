package com.olympus.platform.model.session;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.olympus.platform.constants.ValidationConstant;
import lombok.Data;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.*;
import java.util.List;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UserPostRequestDTO {

  @NotNull(message = "username" + ValidationConstant.MESSAGE_NOT_NULL)
  @NotBlank(message = "username" + ValidationConstant.MESSAGE_NOT_BLANK)
  @NotEmpty(message = "username" + ValidationConstant.MESSAGE_NOT_EMPTY)
  private String username;

  @NotNull(message = "email" + ValidationConstant.MESSAGE_NOT_NULL)
  @NotBlank(message = "email" + ValidationConstant.MESSAGE_NOT_BLANK)
  @NotEmpty(message = "email" + ValidationConstant.MESSAGE_NOT_EMPTY)
  @Email(message = ValidationConstant.MESSAGE_WRONG_EMAIL)
  private String email;

  @NotNull(message = "password" + ValidationConstant.MESSAGE_NOT_NULL)
  @NotBlank(message = "password" + ValidationConstant.MESSAGE_NOT_BLANK)
  @NotEmpty(message = "password" + ValidationConstant.MESSAGE_NOT_EMPTY)
  @Size(max = 1000, min = 8)
  private String password;

  @NotNull(message = "repeatPassword" + ValidationConstant.MESSAGE_NOT_NULL)
  @NotBlank(message = "repeatPassword" + ValidationConstant.MESSAGE_NOT_BLANK)
  @NotEmpty(message = "repeatPassword" + ValidationConstant.MESSAGE_NOT_EMPTY)
  @Size(max = 1000, min = 8)
  private String repeatPassword;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private ProfileInformationDTO profileInfo;

  @NotNull(message = "countryId" + ValidationConstant.MESSAGE_NOT_NULL)
  @NotBlank(message = "countryId" + ValidationConstant.MESSAGE_NOT_BLANK)
  @NotEmpty(message = "countryId" + ValidationConstant.MESSAGE_NOT_EMPTY)
  private Long countryId;

  @NotNull(message = "typeId" + ValidationConstant.MESSAGE_NOT_NULL)
  @NotEmpty(message = "typeId" + ValidationConstant.MESSAGE_NOT_EMPTY)
  private List<Long> typesIds;

}
