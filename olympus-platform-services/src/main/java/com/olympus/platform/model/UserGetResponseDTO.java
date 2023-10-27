package com.olympus.platform.model;

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
public class UserGetResponseDTO {

  private String userId;
  private String username;
  private String email;
  private List<TypeUserResponseDTO> userTypes;
}
