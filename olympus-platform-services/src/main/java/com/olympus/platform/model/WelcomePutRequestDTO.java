package com.olympus.platform.model;

import com.olympus.platform.util.Constants;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
public class WelcomePutRequestDTO {

  @NotNull(message = "welcomeId" + Constants.MESSAGE_NOT_NULL)
  @NotBlank(message = "welcomeId" + Constants.MESSAGE_NOT_BLANK)
  @NotEmpty(message = "welcomeId" + Constants.MESSAGE_NOT_EMPTY)
  private Long welcomeId;

  private String mainTittle;
  private String mainSubTittle;
  private String card1Tittle;
  private String card1SubTittle;
  private String card2Tittle;
  private String card2SubTittle;
  private String card3Tittle;
  private String card3SubTittle;
  private String card4Tittle;
  private String card4SubTittle;
  private String communityTittle;
  private String descComunity;
  private String themeTittle;
  private String descTheme;
  private String profileTittle;
  private String descProfile;
  private String subTittle;
  private String descSub;
  private String teamTittle;
  private String descTeam;
  private String otherText1;
  private String otherText2;

  @NotNull(message = "language" + Constants.MESSAGE_NOT_NULL)
  @NotBlank(message = "language" + Constants.MESSAGE_NOT_BLANK)
  @NotEmpty(message = "language" + Constants.MESSAGE_NOT_EMPTY)
  private String language;
}
