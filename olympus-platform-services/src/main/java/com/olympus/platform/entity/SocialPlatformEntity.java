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
@Table(name = "tb_ol_cm_socials_pt", schema = ConstantsDB.OL_CM_PLATFORM)
@Entity
public class SocialPlatformEntity {

  @Id
  @SequenceGenerator(
      name = "codSocialPt",
      sequenceName = "SC_OL_CM_SOCIAL_PT",
      schema = ConstantsDB.OL_CM_PLATFORM,
      allocationSize = 1)
  @GeneratedValue(generator = "codSocialPt")
  @Column(name = "SOCIAL_PT_ID", nullable = false)
  private Long socialPtId;

  @Column(name = "SOCIAL_PT_DESC", length = ConstantsDB.LARGE_CD_1K, nullable = false)
  private String socialPtDesc;

  @Column(
      name = "SOCIAL_PT_LINK",
      length = ConstantsDB.LARGE_CD_1K,
      unique = true,
      nullable = false)
  private String socialPtLink;

  @Column(name = "SOCIAL_PT_VIEWS", nullable = false)
  private Long socialPtView;

  @Column(name = "SOCIAL_PT_CLICK", nullable = false)
  private Long socialPtClick;

  @Column(name = "STATUS", nullable = false)
  private Boolean status;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "CREATE_AT", nullable = false)
  private Date fechaCreacion;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      referencedColumnName = "SOCIAL_ID",
      name = "SOCIAL_ID",
      foreignKey = @ForeignKey(name = "FK_OL_CM_SOCIAL_PLATFORM_NETWORK"),
      nullable = false)
  private SocialNetworkEntity socialNetwork;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      referencedColumnName = "COMMUNITY_ID",
      name = "COMMUNITY_ID",
      foreignKey = @ForeignKey(name = "FK_OL_CM_COMMUNITY_SOCIAL_PLATFORM"),
      nullable = false)
  private CommunityEntity community;
}
