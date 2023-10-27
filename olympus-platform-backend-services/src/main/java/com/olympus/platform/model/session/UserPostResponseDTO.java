package com.olympus.platform.model.session;

import lombok.*;
import java.util.Date;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UserPostResponseDTO {

  private String userId;
  private Date creationDate;
}
