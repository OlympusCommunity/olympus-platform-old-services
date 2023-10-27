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
@Table(name = ConstantsDB.TB_PROFILE_THEME, schema = ConstantsDB.OL_CM_PLATFORM)
@Entity
public class ProfileThemeEntity {

  @Id
  @SequenceGenerator(
      name = "codProfileTheme",
      sequenceName = ConstantsDB.SC_OL_CM_PROFILE_THEME,
      schema = ConstantsDB.OL_CM_PLATFORM,
      allocationSize = 1)
  @GeneratedValue(generator = "codProfileTheme")
  @Column(name = "PROF_THEME_ID", nullable = false)
  private Long profileThemeId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      referencedColumnName = "PROFILE_ID",
      name = "PROFILE_ID",
      foreignKey = @ForeignKey(name = "FK_OL_CM_PROF_THEME_PROF"),
      nullable = false)
  private ProfileEntity profile;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      referencedColumnName = "THEME_ID",
      name = "THEME_ID",
      foreignKey = @ForeignKey(name = "FK_OL_CM_PROF_THEME_THEME"),
      nullable = false)
  private ThemeEntity theme;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      referencedColumnName = "SUB_THEME_ID",
      name = "SUB_THEME_ID",
      foreignKey = @ForeignKey(name = "FK_OL_CM_PROF_THEME_SUBTHEME"),
      nullable = false)
  private SubThemeEntity subTheme;
}
