package com.olympus.platform.model.representative;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Data;
import lombok.Builder;
import lombok.Getter;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class RepresentativeGetResponseDTO {

  private Long representativeId;
  private String representativeName;
  private String representativeRole;
  private String representativeDesc;
  private byte[] representativeImage;

}
