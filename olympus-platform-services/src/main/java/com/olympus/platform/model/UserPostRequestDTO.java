package com.olympus.platform.model;

import com.olympus.platform.util.Constants;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
public class UserPostRequestDTO {

  @NotNull(message = "username" + Constants.MESSAGE_NOT_NULL)
  @NotBlank(message = "username" + Constants.MESSAGE_NOT_BLANK)
  @NotEmpty(message = "username" + Constants.MESSAGE_NOT_EMPTY)
  private String username;

  @NotNull(message = "email" + Constants.MESSAGE_NOT_NULL)
  @NotBlank(message = "email" + Constants.MESSAGE_NOT_BLANK)
  @NotEmpty(message = "email" + Constants.MESSAGE_NOT_EMPTY)
  @Email(message = Constants.MESSAGE_WRONG_EMAIL)
  private String email;

  @NotNull(message = "password" + Constants.MESSAGE_NOT_NULL)
  @NotBlank(message = "password" + Constants.MESSAGE_NOT_BLANK)
  @NotEmpty(message = "password" + Constants.MESSAGE_NOT_EMPTY)
  @Size(max = 24, min = 8)
  private String password;

  @NotNull(message = "repeatPassword" + Constants.MESSAGE_NOT_NULL)
  @NotBlank(message = "repeatPassword" + Constants.MESSAGE_NOT_BLANK)
  @NotEmpty(message = "repeatPassword" + Constants.MESSAGE_NOT_EMPTY)
  @Size(max = 24, min = 8)
  private String repeatPassword;

  @NotNull(message = "typeId" + Constants.MESSAGE_NOT_NULL)
  @NotEmpty(message = "typeId" + Constants.MESSAGE_NOT_EMPTY)
  private List<Long> typesIds;
}
