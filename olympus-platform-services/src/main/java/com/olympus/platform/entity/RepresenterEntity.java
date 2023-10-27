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
@Table(name = ConstantsDB.TB_REPRESENTER, schema = ConstantsDB.OL_CM_WELCOME)
@Entity
public class RepresenterEntity {

  @Id
  @SequenceGenerator(
      name = "representerId",
      sequenceName = ConstantsDB.SC_OL_CM_REPRESENTER_ID,
      schema = ConstantsDB.OL_CM_WELCOME,
      allocationSize = 1)
  @GeneratedValue(generator = "representerId")
  @Column(name = "REPRESENTER_ID", nullable = false)
  private Long representerId;

  @Column(
      name = "REPRESENTER_NAME",
      length = ConstantsDB.CADENAS_50,
      unique = true,
      nullable = false)
  private String representerName;

  @Column(name = "REPRESENTER_IMG", unique = true, nullable = true)
  private byte[] representerImage;

  @Column(name = "REPRESENTER_ROLE", length = ConstantsDB.CADENAS_50, nullable = true)
  private String representerRole;

  @Column(name = "REPRESENTER_DESC", length = ConstantsDB.LARGE_CD_1K, nullable = true)
  private String representerDesc;

  @Column(name = "REPRESENTER_LANG", length = ConstantsDB.CADENAS_2, nullable = true)
  private String representerLang;

  @Column(name = "STATUS", nullable = false)
  private Boolean status;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = ConstantsDB.CREATED_AT, nullable = false)
  private Date creationDate;

  @Column(name = ConstantsDB.UPDATED_AT, nullable = true)
  private Date editionDate;

  @Column(name = ConstantsDB.DELETED_AT, nullable = true)
  private Date deleteDate;
}
