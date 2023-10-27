package com.olympus.platform.entity;

import com.olympus.platform.util.ConstantsDB;
import java.io.Serializable;
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
@Table(name = ConstantsDB.TB_AUDIT, schema = ConstantsDB.OL_CM_SECURITY)
@Entity
public class AuditEntity implements Serializable {

  @Id
  @SequenceGenerator(
      name = "codAudit",
      sequenceName = ConstantsDB.SC_OL_CM_SECURITY_AUDIT,
      schema = ConstantsDB.OL_CM_SECURITY,
      allocationSize = 1)
  @GeneratedValue(generator = "codAudit")
  @Column(name = "AUDIT_ID", nullable = false)
  private Long auditId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      referencedColumnName = "USER_ID",
      name = "USER_ID",
      foreignKey = @ForeignKey(name = ConstantsDB.FK_OL_CM_AUDIT_USER),
      nullable = false)
  private UserEntity user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      referencedColumnName = "ACTION_ID",
      name = "ACTION_ID",
      foreignKey = @ForeignKey(name = ConstantsDB.FK_OL_CM_AUDIT_ACTION),
      nullable = false)
  private ActionAuditEntity action;

  @Column(name = "BROWSER", length = ConstantsDB.CADENAS_100, nullable = true)
  private String browser;

  @Column(name = "IP_RECEIVER", length = ConstantsDB.IP_ADRESS, nullable = true)
  private String ipReceiver;

  @Column(name = "REASON", length = ConstantsDB.CADENAS_100, nullable = false)
  private String reason;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "DATE", nullable = false)
  private Date date;

  private static final long serialVersionUID = 1L;
}
