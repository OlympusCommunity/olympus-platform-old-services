package com.olympus.platform.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class WelcomeGetResponseDTO {

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

  private List<RepresenterDTO> representers;
}
