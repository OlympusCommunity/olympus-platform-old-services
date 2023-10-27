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
@Table(name = ConstantsDB.TB_STATUS, schema = ConstantsDB.OL_CM_OTHER)
@Entity
public class StatusEntity {

  @Id
  @SequenceGenerator(
      name = "codStatusId",
      sequenceName = ConstantsDB.SC_OL_CM_STATUS_ID,
      schema = ConstantsDB.OL_CM_OTHER,
      allocationSize = 1)
  @GeneratedValue(generator = "codStatusId")
  @Column(name = "STATUS_ID", nullable = false)
  private Long statusId;

  @Column(name = "STATUS_DESC", length = ConstantsDB.CADENAS_50, unique = true, nullable = false)
  private String statusDesc;
}
