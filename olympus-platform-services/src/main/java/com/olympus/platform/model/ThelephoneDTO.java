package com.olympus.platform.model;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class ThelephoneDTO {

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Long telId;

  private String prefTel;
  private String numTel;
  private Long countryId;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private CountryDTO country;

  private String numPrefAndTel;
}
