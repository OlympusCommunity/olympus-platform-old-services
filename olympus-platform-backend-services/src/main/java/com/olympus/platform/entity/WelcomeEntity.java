package com.olympus.platform.entity;

import com.olympus.platform.constants.DatabaseConstant;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name = DatabaseConstant.TB_WELCOME, schema = DatabaseConstant.OL_CM_WELCOME)
@Entity
public class WelcomeEntity implements Serializable {

    @Id
    @SequenceGenerator(
            name = "gen_welcome",
            sequenceName = DatabaseConstant.SC_OL_CM_WELCOME_ID,
            schema = DatabaseConstant.OL_CM_WELCOME,
            allocationSize = 1)
    @GeneratedValue(generator = "gen_welcome")
    @Column(name = "WELCOME_ID", nullable = false)
    private Long welcomeId;

    @Column(name = "MAIN_TITLE", nullable = false, length = DatabaseConstant.LARGE_CD_1K)
    private String mainTittle;

    @Column(name = "MAIN_SUB_TITLE", nullable = false, length = DatabaseConstant.LARGE_CD_1K)
    private String mainSubTittle;

    @Column(name = "CARD1_TITLE", nullable = false, length = DatabaseConstant.CADENAS_50)
    private String card1Tittle;

    @Column(name = "CARD1_SUB_TITLE", nullable = false, length = DatabaseConstant.LARGE_CD_1K)
    private String card1SubTittle;

    @Column(name = "CARD2_TITLE", nullable = false, length = DatabaseConstant.CADENAS_50)
    private String card2Tittle;

    @Column(name = "CARD2_SUB_TITLE", nullable = false, length = DatabaseConstant.LARGE_CD_1K)
    private String card2SubTittle;

    @Column(name = "CARD3_TITLE", nullable = false, length = DatabaseConstant.CADENAS_50)
    private String card3Tittle;

    @Column(name = "CARD3_SUB_TITLE", nullable = false, length = DatabaseConstant.LARGE_CD_1K)
    private String card3SubTittle;

    @Column(name = "CARD4_TITLE", nullable = false, length = DatabaseConstant.CADENAS_50)
    private String card4Tittle;

    @Column(name = "CARD4_SUB_TITLE", nullable = false, length = DatabaseConstant.LARGE_CD_1K)
    private String card4SubTittle;

    @Column(name = "COMMUNITY_TITLE", nullable = false, length = DatabaseConstant.CADENAS_50)
    private String communityTittle;

    @Column(name = "DESC_COMMUNITY", nullable = false, length = DatabaseConstant.LARGE_CD_1K)
    private String descCommunity;

    @Column(name = "THEME_TITLE", nullable = false, length = DatabaseConstant.CADENAS_50)
    private String themeTittle;

    @Column(name = "DESC_THEME", nullable = false, length = DatabaseConstant.LARGE_CD_1K)
    private String descTheme;

    @Column(name = "PROFILE_TITLE", nullable = false, length = DatabaseConstant.CADENAS_50)
    private String profileTittle;

    @Column(name = "DESC_PROFILE", nullable = false, length = DatabaseConstant.LARGE_CD_1K)
    private String descProfile;

    @Column(name = "SUB_TITLE", nullable = false, length = DatabaseConstant.CADENAS_50)
    private String subTittle;

    @Column(name = "DESC_SUB", nullable = false, length = DatabaseConstant.LARGE_CD_1K)
    private String descSub;

    @Column(name = "TEAM_TITLE", nullable = false, length = DatabaseConstant.CADENAS_50)
    private String teamTittle;

    @Column(name = "DESC_TEAM", nullable = false, length = DatabaseConstant.LARGE_CD_1K)
    private String descTeam;

    @Column(name = "OTHER_TEXT1", nullable = false, length = DatabaseConstant.CADENAS_50)
    private String otherText1;

    @Column(name = "OTHER_TEXT2", nullable = false, length = DatabaseConstant.LARGE_CD_1K)
    private String otherText2;

    @Column(name = "WELCOME_LANG", length = DatabaseConstant.CADENAS_2, nullable = true)
    private String welcomeLang;

    @Column(name = DatabaseConstant.STATUS, nullable = false)
    private Boolean status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = DatabaseConstant.CREATED_AT, nullable = false)
    private Date creationDate;

    @Column(name = DatabaseConstant.UPDATED_AT)
    private Date editionDate;

    @Column(name = DatabaseConstant.DELETED_AT)
    private Date deleteDate;

}
