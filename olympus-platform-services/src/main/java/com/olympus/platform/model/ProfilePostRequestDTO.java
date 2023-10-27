package com.olympus.platform.model;

import com.olympus.platform.util.Constants;
import java.util.List;
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
public class ProfilePostRequestDTO {

  @NotNull(message = "name" + Constants.MESSAGE_NOT_NULL)
  @NotBlank(message = "name" + Constants.MESSAGE_NOT_BLANK)
  @NotEmpty(message = "name" + Constants.MESSAGE_NOT_EMPTY)
  private String name;

  @NotNull(message = "name" + Constants.MESSAGE_NOT_NULL)
  @NotBlank(message = "name" + Constants.MESSAGE_NOT_BLANK)
  @NotEmpty(message = "name" + Constants.MESSAGE_NOT_EMPTY)
  private String surname;

  private String shortInfo;
  private String longInfo;
  private String alias;
  private String nickname;
  private String birthday;

  @NotNull(message = "countryId" + Constants.MESSAGE_NOT_NULL)
  private Long countryId;

  @NotNull(message = "city" + Constants.MESSAGE_NOT_NULL)
  @NotBlank(message = "city" + Constants.MESSAGE_NOT_BLANK)
  @NotEmpty(message = "city" + Constants.MESSAGE_NOT_EMPTY)
  private String city;

  @NotNull(message = "userId" + Constants.MESSAGE_NOT_NULL)
  @NotBlank(message = "userId" + Constants.MESSAGE_NOT_BLANK)
  @NotEmpty(message = "userId" + Constants.MESSAGE_NOT_EMPTY)
  private String userId;

  private List<ThelephoneDTO> thelephones;
}
