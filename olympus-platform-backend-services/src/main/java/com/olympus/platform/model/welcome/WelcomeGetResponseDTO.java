package com.olympus.platform.model.welcome;

import com.olympus.platform.model.representative.RepresentativeDTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Data;
import lombok.Builder;
import lombok.Getter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode
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
  private List<RepresentativeDTO> representatives;
}
