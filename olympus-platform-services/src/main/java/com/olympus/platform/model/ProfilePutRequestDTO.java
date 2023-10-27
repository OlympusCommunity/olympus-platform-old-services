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
public class ProfilePutRequestDTO {

  @NotNull(message = "profileId" + Constants.MESSAGE_NOT_NULL)
  @NotBlank(message = "profileId" + Constants.MESSAGE_NOT_BLANK)
  @NotEmpty(message = "profileId" + Constants.MESSAGE_NOT_EMPTY)
  private String profileId;

  private String name;
  private String surname;
  private String shortInfo;
  private String longInfo;
  private String alias;
  private String nickname;
  private String birthday;
  private Long countryId;
  private String city;
  private String userId;
  private List<ThelephoneDTO> thelephones;
}
