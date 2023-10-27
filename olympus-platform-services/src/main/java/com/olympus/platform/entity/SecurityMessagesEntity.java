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
@Table(name = "tb_ol_cm_messages", schema = "ol_cm_security")
@Entity
public class SecurityMessagesEntity {

  @Id
  @SequenceGenerator(
      name = "codSecurityMsnKeys",
      sequenceName = "SC_OL_CM_SECURITY_MSN_KEYS",
      schema = "ol_cm_security",
      allocationSize = 1)
  @GeneratedValue(generator = "codSecurityMsnKeys")
  @Column(name = "ID_SK", nullable = false)
  private Long codSecurityKeys;

  @Column(name = "KEY_MESSAGES", length = ConstantsDB.LARGE_CD_1K, unique = true, nullable = false)
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
