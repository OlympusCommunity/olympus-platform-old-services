package com.olympus.platform.entity;

import com.olympus.platform.util.ConstantsDB;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = ConstantsDB.TB_ROLE, schema = ConstantsDB.OL_CM_PLATFORM)
@Entity
public class RoleEntity {

  @Id
  @SequenceGenerator(
      name = "codRole",
      sequenceName = "SC_OL_CM_ROLE_ID",
      schema = ConstantsDB.OL_CM_PLATFORM,
      allocationSize = 1)
  @GeneratedValue(generator = "codRole")
  @Column(name = "ROLE_ID", nullable = false)
  private Long roleId;

  @Column(name = "ROLE_NAME", length = ConstantsDB.CADENAS_50, unique = true, nullable = false)
  private String roleName;

  @Column(name = "ROLE_DESC", length = ConstantsDB.LARGE_CD_1K, nullable = false)
  private String roleDesc;

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
