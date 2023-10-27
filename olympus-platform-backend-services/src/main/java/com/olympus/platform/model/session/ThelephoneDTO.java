package com.olympus.platform.model.session;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ThelephoneDTO {

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Long telId;

  private String prefTel;
  private String numTel;
  private Long countryId;
  private String numPrefAndTel;
}
