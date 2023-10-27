package com.olympus.platform.entity;

import com.olympus.platform.util.ConstantsDB;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = ConstantsDB.TB_COMMUNITY, schema = ConstantsDB.OL_CM_PLATFORM)
@Entity
public class CommunityEntity {

  @Id
  @Column(name = "COMMUNITY_ID", nullable = false, length = ConstantsDB.LONGITUD_35_ID)
  private String communityId;

  @Column(name = "CM_NAME", length = ConstantsDB.LARGE_CD_1K, unique = true, nullable = false)
  private String cmName;

  @Column(name = "CM_DESC", length = ConstantsDB.LARGE_DESC_INFO_5K, nullable = true)
  private String cmDesc;

  @Column(
      name = "CM_SCORE",
      precision = ConstantsDB.PRECISION_4,
      scale = ConstantsDB.SCALE_2,
      nullable = true)
  private BigDecimal cmScore;

  @Column(name = "CM_VIEWS", nullable = true)
  private Long cmViews;

  @Column(name = ConstantsDB.STATUS, nullable = false)
  private Boolean status;

  @Column(name = "CM_PHOTO", nullable = true)
  private byte[] cmPhoto;

  @Column(name = "CM_PHOTO_PATH", length = ConstantsDB.LARGE_CD_1K, nullable = true)
  private String cmPhotoPath;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = ConstantsDB.CREATED_AT, nullable = false)
  private Date creationDate;

  @Column(name = ConstantsDB.UPDATED_AT, nullable = true)
  private Date editionDate;

  @Column(name = ConstantsDB.DELETED_AT, nullable = true)
  private Date deleteDate;

  @OneToMany(mappedBy = "community")
  Set<CommunityThemeEntity> communitiesCategories;
}
