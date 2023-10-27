package com.olympus.platform.entity;

import com.olympus.platform.constants.DatabaseConstant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = DatabaseConstant.TB_KEYS, schema = DatabaseConstant.OL_CM_SECURITY)
@Entity
public class SecurityKeyEntity implements Serializable {

  @Id
  @SequenceGenerator(
      name = "gen_security_key",
      sequenceName = DatabaseConstant.SC_OL_CM_SECURITY_KEYS,
      schema = DatabaseConstant.OL_CM_SECURITY,
      allocationSize = 1)
  @GeneratedValue(generator = "gen_security_key")
  @Column(name = "ID_SK", nullable = false)
  private Long codSecurityKey;

  @Column(name = "KEY_PASS", length = DatabaseConstant.LARGE_CD_1K, unique = true, nullable = false)
  private String keyPass;

  @Column(name = "IV_KEY", length = DatabaseConstant.LARGE_CD_16, unique = true, nullable = false)
  private String ivKey;

  @Column(name = "SALT_KEY", length = DatabaseConstant.LARGE_CD_32, unique = true, nullable = false)
  private String saltKey;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = DatabaseConstant.CREATED_AT, nullable = false)
  private Date creationDate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      referencedColumnName = "USER_ID",
      name = "USER_ID",
      foreignKey = @ForeignKey(name = DatabaseConstant.FK_OL_CM_SECURITY_KEY_USER),
      nullable = false)
  private UserEntity user;
}
