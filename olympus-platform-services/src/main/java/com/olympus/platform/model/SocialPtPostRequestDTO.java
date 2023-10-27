package com.olympus.platform.model;

import com.olympus.platform.util.Constants;
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
public class SocialPtPostRequestDTO {

  @NotNull(message = "socialPtDesc" + Constants.MESSAGE_NOT_NULL)
  @NotBlank(message = "socialPtDesc" + Constants.MESSAGE_NOT_BLANK)
  @NotEmpty(message = "socialPtDesc" + Constants.MESSAGE_NOT_EMPTY)
  private String socialPtDesc;

  @NotNull(message = "socialPtLink" + Constants.MESSAGE_NOT_NULL)
  @NotBlank(message = "socialPtLink" + Constants.MESSAGE_NOT_BLANK)
  @NotEmpty(message = "socialPtLink" + Constants.MESSAGE_NOT_EMPTY)
  private String socialPtLink;

  @NotNull(message = "socialId" + Constants.MESSAGE_NOT_NULL)
  private Long socialId;

  @NotNull(message = "communityId" + Constants.MESSAGE_NOT_NULL)
  @NotBlank(message = "communityId" + Constants.MESSAGE_NOT_BLANK)
  @NotEmpty(message = "communityId" + Constants.MESSAGE_NOT_EMPTY)
  private String communityId;
}
