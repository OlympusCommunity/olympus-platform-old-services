package com.olympus.platform.entity;

import com.olympus.platform.util.ConstantsDB;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = ConstantsDB.TB_WELCOME, schema = ConstantsDB.OL_CM_WELCOME)
@Entity
public class WelcomeEntity implements Serializable {

  @Id
  @SequenceGenerator(
      name = "scWelcomeId",
      sequenceName = ConstantsDB.SC_OL_CM_WELCOME_ID,
      schema = ConstantsDB.OL_CM_WELCOME,
      allocationSize = 1)
  @GeneratedValue(generator = "scWelcomeId")
  @Column(name = "WELCOME_ID", nullable = false)
  private Long welcomeId;

  @Column(name = "MAIN_TIITLE", nullable = false, length = ConstantsDB.LARGE_CD_1K)
  private String mainTittle;

  @Column(name = "MAIN_SUB_TIITLE", nullable = false, length = ConstantsDB.LARGE_CD_1K)
  private String mainSubTittle;

  @Column(name = "CARD1_TIITLE", nullable = false, length = ConstantsDB.CADENAS_50)
  private String card1Tittle;

  @Column(name = "CARD1_SUB_TIITLE", nullable = false, length = ConstantsDB.LARGE_CD_1K)
  private String card1SubTittle;

  @Column(name = "CARD2_TIITLE", nullable = false, length = ConstantsDB.CADENAS_50)
  private String card2Tittle;

  @Column(name = "CARD2_SUB_TIITLE", nullable = false, length = ConstantsDB.LARGE_CD_1K)
  private String card2SubTittle;

  @Column(name = "CARD3_TIITLE", nullable = false, length = ConstantsDB.CADENAS_50)
  private String card3Tittle;

  @Column(name = "CARD3_SUB_TIITLE", nullable = false, length = ConstantsDB.LARGE_CD_1K)
  private String card3SubTittle;

  @Column(name = "CARD4_TIITLE", nullable = false, length = ConstantsDB.CADENAS_50)
  private String card4Tittle;

  @Column(name = "CARD4_SUB_TIITLE", nullable = false, length = ConstantsDB.LARGE_CD_1K)
  private String card4SubTittle;

  @Column(name = "COMMUNITY_TIITLE", nullable = false, length = ConstantsDB.CADENAS_50)
  private String communityTittle;

  @Column(name = "DESC_COMMUNITY", nullable = false, length = ConstantsDB.LARGE_CD_1K)
  private String descComunity;

  @Column(name = "THEME_TITTLE", nullable = false, length = ConstantsDB.CADENAS_50)
  private String themeTittle;

  @Column(name = "DESC_THEME", nullable = false, length = ConstantsDB.LARGE_CD_1K)
  private String descTheme;

  @Column(name = "PROFILE_TITTLE", nullable = false, length = ConstantsDB.CADENAS_50)
  private String profileTittle;

  @Column(name = "DESC_PROFILE", nullable = false, length = ConstantsDB.LARGE_CD_1K)
  private String descProfile;

  @Column(name = "SUB_TITTLE", nullable = false, length = ConstantsDB.CADENAS_50)
  private String subTittle;

  @Column(name = "DESC_SUB", nullable = false, length = ConstantsDB.LARGE_CD_1K)
  private String descSub;

  @Column(name = "TEAM_TIITLE", nullable = false, length = ConstantsDB.CADENAS_50)
  private String teamTittle;

  @Column(name = "DESC_TEAM", nullable = false, length = ConstantsDB.LARGE_CD_1K)
  private String descTeam;

  @Column(name = "OTHER_TEXT1", nullable = false, length = ConstantsDB.CADENAS_50)
  private String otherText1;

  @Column(name = "OTHER_TEXT2", nullable = false, length = ConstantsDB.LARGE_CD_1K)
  private String otherText2;

  @Column(name = "WELCOME_LANG", length = ConstantsDB.CADENAS_2, nullable = true)
  private String welcomeLang;

  @Column(name = ConstantsDB.STATUS, nullable = false)
  private Boolean status;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = ConstantsDB.CREATED_AT, nullable = false)
  private Date creationDate;

  @Column(name = ConstantsDB.UPDATED_AT, nullable = true)
  private Date editionDate;

  @Column(name = ConstantsDB.DELETED_AT, nullable = true)
  private Date deleteDate;

  private static final long serialVersionUID = 1L;
}
