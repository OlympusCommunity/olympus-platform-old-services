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
@Table(name = DatabaseConstant.TB_MSN, schema = DatabaseConstant.OL_CM_SECURITY)
@Entity
public class SecurityMessageEntity implements Serializable {

  @Id
  @SequenceGenerator(
      name = "gen_security_msn_key",
      sequenceName = "SC_OL_CM_SECURITY_MSN_KEYS",
      schema = DatabaseConstant.OL_CM_SECURITY,
      allocationSize = 1)
  @GeneratedValue(generator = "gen_security_msn_key")
  @Column(name = "ID_SK", nullable = false)
  private Long codSecurityKeys;

  @Column(name = "KEY_MESSAGES", length = DatabaseConstant.LARGE_CD_1K, unique = true, nullable = false)
  private String keyMessages;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "CREATE_AT", nullable = false)
  private Date fechaCreacion;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      referencedColumnName = "USER_ID",
      name = "USER_ID",
      foreignKey = @ForeignKey(name = "FK_OL_CM_PROFILE_USER"),
      nullable = false)
  private UserEntity user;
}
