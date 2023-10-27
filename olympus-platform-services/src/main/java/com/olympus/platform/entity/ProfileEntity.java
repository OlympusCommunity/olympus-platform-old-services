package com.olympus.platform.entity;

import com.olympus.platform.util.ConstantsDB;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = ConstantsDB.TB_PROFILE, schema = ConstantsDB.OL_CM_SESSION)
@Entity
public class ProfileEntity {

  @Id
  @Column(name = "PROFILE_ID", nullable = false, length = ConstantsDB.LONGITUD_PF_ID_27)
  private String profileId;

  @Column(name = "NICKNAME", nullable = true, unique = true, length = ConstantsDB.CADENAS_100)
  private String nickname;

  @Column(name = "ALIAS", nullable = true, length = ConstantsDB.CADENAS_50)
  private String alias;

  @Column(name = "PROF_NAME", nullable = false, length = ConstantsDB.CADENAS_50)
  private String name;

  @Column(name = "SURNAME", nullable = false, length = ConstantsDB.CADENAS_50)
  private String surname;

  @Column(name = "BIRTHDATE", nullable = true)
  private Date birthday;

  @Column(name = "SHORT_INFO", nullable = true, length = ConstantsDB.LARGE_CD_1K)
  private String shortInfo;

  @Column(name = "LONG_INFO", nullable = true, length = ConstantsDB.LARGE_DESC_INFO_5K)
  private String longInfo;

  @Column(name = "CITY", nullable = false, length = ConstantsDB.CADENAS_50)
  private String city;

  @Column(name = "PROFILE_PHOTO", nullable = true)
  private byte[] profilePhoto;

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
      referencedColumnName = "USER_ID",
      name = "USER_ID",
      foreignKey = @ForeignKey(name = ConstantsDB.FK_OL_CM_PROFILE_USER),
      nullable = false)
  private UserEntity user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      referencedColumnName = "COUNTRY_ID",
      name = "COUNTRY_ID",
      foreignKey = @ForeignKey(name = ConstantsDB.FK_OL_CM_PROFILE_COUNTRY),
      nullable = false)
  private CountryEntity country;
}
