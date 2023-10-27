package com.olympus.platform.model;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class ThemeCommunityDTO {

  private Long themeId;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String themeName;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private List<Long> subThemes;
}
