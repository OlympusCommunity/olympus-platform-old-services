package com.olympus.platform.entity;

import com.olympus.platform.util.ConstantsDB;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_ol_cm_sub_themes", schema = ConstantsDB.OL_CM_PLATFORM)
@Entity
public class SubThemeEntity {

  @Id
  @SequenceGenerator(
      name = "codSubThemeId",
      sequenceName = "SC_OL_CM_SUB_THEME_ID",
      schema = ConstantsDB.OL_CM_PLATFORM,
      allocationSize = 1)
  @GeneratedValue(generator = "codSubThemeId")
  @Column(name = "SUB_THEME_ID", nullable = false)
  private Long subThemeId;

  @Column(
      name = "SUB_THEME_NAME",
      length = ConstantsDB.CADENAS_100,
      unique = true,
      nullable = false)
  private String subThemeName;

  @Column(name = "SUB_THEME_DESC", length = ConstantsDB.LARGE_CD_1K, nullable = false)
  private String subThemeDesc;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      referencedColumnName = "THEME_ID",
      name = "THEME_ID",
      foreignKey = @ForeignKey(name = "FK_OL_CM_THEME_SUB_THEME"),
      nullable = false)
  private ThemeEntity theme;
}
