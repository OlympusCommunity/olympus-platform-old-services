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
public class ProfileGetResponseDTO {

  private String profileId;
  private String name;
  private String surname;
  private String shortInfo;
  private String longInfo;
  private String alias;
  private String nickname;
  private String birthday;
  private CountryDTO country;
  private String city;
  private UserGetResponseDTO user;
  private List<ThelephoneDTO> thelephones;
  private String creationDate;
  private String editionDate;
}
