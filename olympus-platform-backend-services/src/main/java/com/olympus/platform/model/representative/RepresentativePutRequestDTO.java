package com.olympus.platform.model.representative;

import com.olympus.platform.constants.ValidationConstant;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Data;
import lombok.Builder;
import lombok.Getter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class RepresentativePutRequestDTO {

  @NotNull(message = "representativeId" + ValidationConstant.MESSAGE_NOT_NULL)
  @NotBlank(message = "representativeId" + ValidationConstant.MESSAGE_NOT_BLANK)
  @NotEmpty(message = "representativeId" + ValidationConstant.MESSAGE_NOT_EMPTY)
  private Long representativeId;

  @NotNull(message = "representativeName" + ValidationConstant.MESSAGE_NOT_NULL)
  @NotBlank(message = "representativeName" + ValidationConstant.MESSAGE_NOT_BLANK)
  @NotEmpty(message = "representativeName" + ValidationConstant.MESSAGE_NOT_EMPTY)
  private String representativeName;

  @NotNull(message = "representativeRole" + ValidationConstant.MESSAGE_NOT_NULL)
  @NotBlank(message = "representativeRole" + ValidationConstant.MESSAGE_NOT_BLANK)
  @NotEmpty(message = "representativeRole" + ValidationConstant.MESSAGE_NOT_EMPTY)
  private String representativeRole;

  private String representativeDesc;

  private byte[] representativeImage;
}
