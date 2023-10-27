package com.olympus.platform.entity;

import com.olympus.platform.util.ConstantsDB;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = ConstantsDB.TB_THEME, schema = ConstantsDB.OL_CM_PLATFORM)
@Entity
public class ThemeEntity {

  @Id
  @SequenceGenerator(
      name = "codThemeId",
      sequenceName = "SC_OL_CM_THEME_ID",
      schema = ConstantsDB.OL_CM_PLATFORM,
      allocationSize = 1)
  @GeneratedValue(generator = "codThemeId")
  @Column(name = "THEME_ID", nullable = false)
  private Long themeId;

  @Column(name = "THEME_NAME", length = ConstantsDB.CADENAS_100, unique = true, nullable = false)
  private String themeName;

  @Column(name = "THEME_DESC", length = ConstantsDB.LARGE_CD_1K, nullable = false)
  private String themeDesc;
}
