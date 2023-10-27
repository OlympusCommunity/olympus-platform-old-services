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
@Table(name = ConstantsDB.TB_KEYS, schema = ConstantsDB.OL_CM_SECURITY)
@Entity
public class SecurityKeysEntity {

  @Id
  @SequenceGenerator(
      name = "codSecurityKeys",
      sequenceName = ConstantsDB.SC_OL_CM_SECURITY_KEYS,
      schema = ConstantsDB.OL_CM_SECURITY,
      allocationSize = 1)
  @GeneratedValue(generator = "codSecurityKeys")
  @Column(name = "ID_SK", nullable = false)
  private Long codSecurityKey;

  @Column(name = "KEY_PASS", length = ConstantsDB.LARGE_CD_1K, unique = true, nullable = false)
  private String keyPass;

  @Column(name = "IV_KEY", length = ConstantsDB.LARGE_CD_16, unique = true, nullable = false)
  private String ivKey;

  @Column(name = "SALT_KEY", length = ConstantsDB.LARGE_CD_32, unique = true, nullable = false)
  private String saltKey;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = ConstantsDB.CREATED_AT, nullable = false)
  private Date creationDate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      referencedColumnName = "USER_ID",
      name = "USER_ID",
      foreignKey = @ForeignKey(name = ConstantsDB.FK_OL_CM_SECURITY_KEY_USER),
      nullable = false)
  private UserEntity user;
}
