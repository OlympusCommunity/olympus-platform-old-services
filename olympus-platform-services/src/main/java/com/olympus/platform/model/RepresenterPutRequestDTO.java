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
public class RepresenterPutRequestDTO {

  @NotNull(message = "representerId" + Constants.MESSAGE_NOT_NULL)
  @NotBlank(message = "representerId" + Constants.MESSAGE_NOT_BLANK)
  @NotEmpty(message = "representerId" + Constants.MESSAGE_NOT_EMPTY)
  private Long representerId;

  @NotNull(message = "representerName" + Constants.MESSAGE_NOT_NULL)
  @NotBlank(message = "representerName" + Constants.MESSAGE_NOT_BLANK)
  @NotEmpty(message = "representerName" + Constants.MESSAGE_NOT_EMPTY)
  private String representerName;

  @NotNull(message = "representerRole" + Constants.MESSAGE_NOT_NULL)
  @NotBlank(message = "representerRole" + Constants.MESSAGE_NOT_BLANK)
  @NotEmpty(message = "representerRole" + Constants.MESSAGE_NOT_EMPTY)
  private String representerRole;

  private String representerDesc;

  private byte[] representerImage;
}
