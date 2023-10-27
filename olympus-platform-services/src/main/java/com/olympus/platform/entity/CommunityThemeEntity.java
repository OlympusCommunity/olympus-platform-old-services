package com.olympus.platform.entity;

import com.olympus.platform.util.ConstantsDB;
import java.util.Date;
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
@Table(name = ConstantsDB.TB_COMMUNITY_THEME, schema = ConstantsDB.OL_CM_PLATFORM)
@Entity
public class CommunityThemeEntity {

  @Id
  @SequenceGenerator(
      name = "codComCat",
      sequenceName = ConstantsDB.SC_OL_CM_COM_CAT_ID,
      schema = ConstantsDB.OL_CM_PLATFORM,
      allocationSize = 1)
  @GeneratedValue(generator = "codComCat")
  @Column(name = "COM_CAT_ID", nullable = false)
  private Long comCatId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      referencedColumnName = "COMMUNITY_ID",
      name = "COMMUNITY_ID",
      foreignKey = @ForeignKey(name = "FK_OL_CM_COMMUNITY_THEME"),
      nullable = false)
  private CommunityEntity community;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      referencedColumnName = "THEME_ID",
      name = "THEME_ID",
      foreignKey = @ForeignKey(name = "FK_OL_CM_THEME_COMMUNITY"),
      nullable = false)
  private ThemeEntity theme;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      referencedColumnName = "SUB_THEME_ID",
      name = "SUB_THEME_ID",
      foreignKey = @ForeignKey(name = "FK_OL_CM_THEME_COMMUNITY_SUB_THEME"),
      nullable = false)
  private SubThemeEntity subTheme;

  @Column(name = ConstantsDB.STATUS, nullable = false)
  private Boolean status;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = ConstantsDB.CREATED_AT, nullable = false)
  private Date creationDate;

  @Column(name = ConstantsDB.UPDATED_AT, nullable = true)
  private Date editionDate;

  @Column(name = ConstantsDB.DELETED_AT, nullable = true)
  private Date deleteDate;
}
