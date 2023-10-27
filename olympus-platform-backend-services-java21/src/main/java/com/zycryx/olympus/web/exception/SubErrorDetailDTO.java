package com.zycryx.olympus.web.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class SubErrorDetailDTO {

  private String object;

  private String field;

  @JsonProperty("rejected_value")
  private Object rejectedValue;

  private String message;

  public SubErrorDetailDTO(String object, String message) {
    this.object = object;
    this.message = message;
  }
}
