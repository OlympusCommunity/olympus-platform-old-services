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
@Table(name = ConstantsDB.TB_TEL, schema = ConstantsDB.OL_CM_SESSION)
@Entity
public class ThelephoneEntity {

  @Id
  @SequenceGenerator(
      name = "idAdmTelSeqGenerator",
      sequenceName = ConstantsDB.SC_OL_CM_TEL_PROFILE,
      schema = ConstantsDB.OL_CM_SESSION,
      allocationSize = 1)
  @GeneratedValue(generator = "idAdmTelSeqGenerator")
  @Column(name = "TEL_ID", nullable = false)
  private Long telId;

  @Column(name = "NUM_TEL", length = ConstantsDB.TEL_LONG_20, nullable = false)
  private String numTel;

  @Column(name = ConstantsDB.STATUS, nullable = false)
  private Boolean status;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = ConstantsDB.CREATED_AT, nullable = false)
  private Date creationDate;

  @Column(name = ConstantsDB.UPDATED_AT, nullable = true)
  private Date editionDate;

  @Column(name = ConstantsDB.DELETED_AT, nullable = true)
  private Date deleteDate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      referencedColumnName = "PROFILE_ID",
      name = "PROFILE_ID",
      foreignKey = @ForeignKey(name = "FK_OL_CM_TEL_PROFILE"),
      nullable = false)
  private ProfileEntity profile;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      referencedColumnName = "COUNTRY_ID",
      name = "COUNTRY_ID",
      foreignKey = @ForeignKey(name = "FK_OL_CM_TEL_COUNTRY"),
      nullable = false)
  private CountryEntity country;
}
