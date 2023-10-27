package com.olympus.platform.model;

import com.olympus.platform.util.Constants;
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
public class UserRequestLoginDTO {

  @NotNull(message = "usernameOrEmail" + Constants.MESSAGE_NOT_NULL)
  @NotBlank(message = "usernameOrEmail" + Constants.MESSAGE_NOT_BLANK)
  @NotEmpty(message = "usernameOrEmail" + Constants.MESSAGE_NOT_EMPTY)
  private String usernameOrEmail;

  @NotNull(message = "password" + Constants.MESSAGE_NOT_NULL)
  @NotBlank(message = "password" + Constants.MESSAGE_NOT_BLANK)
  @NotEmpty(message = "password" + Constants.MESSAGE_NOT_EMPTY)
  @Size(max = 24, min = 8)
  private String password;
}
