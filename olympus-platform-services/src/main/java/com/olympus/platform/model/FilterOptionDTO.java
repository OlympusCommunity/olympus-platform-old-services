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
public class FilterOptionDTO {

  private String filterOptionId;
  private String filterOptionDesc;
  private List<SubFilterOptionDTO> subFilters;
}
