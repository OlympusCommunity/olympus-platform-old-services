package com.olympus.platform.entity;

import com.olympus.platform.util.ConstantsDB;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
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
public class ActionAuditEntity {

  @Id
  @SequenceGenerator(
      name = "codAction",
      sequenceName = ConstantsDB.SC_OL_CM_SECURITY_ACTION,
      schema = ConstantsDB.OL_CM_SECURITY,
      allocationSize = 1)
  @GeneratedValue(generator = "codAction")
  @Column(name = "ACTION_ID", nullable = false)
  private Long auditId;

  @Column(name = "ACTION_DESC", length = ConstantsDB.LARGE_CD_1K, nullable = false)
  private String actionDesc;
}
