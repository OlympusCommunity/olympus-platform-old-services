package com.olympus.platform.model;

import java.util.Date;
import java.util.List;
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
public class SocialPtPostResponseDTO {

  private List<Long> socialPtId;

  private Date fechaCreacion;

  private String profileId;
}
