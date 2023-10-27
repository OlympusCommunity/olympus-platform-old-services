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
@Table(name = ConstantsDB.TB_MANAGEMENT, schema = ConstantsDB.OL_CM_PLATFORM)
@Entity
public class CommunityManagementEntity {

  @Id
  @SequenceGenerator(
      name = "codComProfId",
      sequenceName = ConstantsDB.SC_OL_CM_COM_PROF_ID,
      schema = ConstantsDB.OL_CM_PLATFORM,
      allocationSize = 1)
  @GeneratedValue(generator = "codComProfId")
  @Column(name = "COM_PROF_ID", nullable = false)
  private Long comProfId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      referencedColumnName = "COMMUNITY_ID",
      name = "COMMUNITY_ID",
      foreignKey = @ForeignKey(name = "FK_OL_CM_MG_CT"),
      nullable = false)
  private CommunityEntity community;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      referencedColumnName = "PROFILE_ID",
      name = "PROFILE_ID",
      foreignKey = @ForeignKey(name = "FK_OL_CM_MG_ROLE"),
      nullable = false)
  private ProfileEntity profile;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      referencedColumnName = "ROLE_ID",
      name = "ROLE_ID",
      foreignKey = @ForeignKey(name = "FK_OL_CM_MG_PROFILE"),
      nullable = false)
  private RoleEntity role;

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
