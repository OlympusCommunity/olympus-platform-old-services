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
@Table(name = ConstantsDB.TB_LEVEL, schema = ConstantsDB.OL_CM_PLATFORM)
@Entity
public class LevelEntity {

  @Id
  @SequenceGenerator(
      name = "codLevel",
      sequenceName = ConstantsDB.SC_OL_CM_LEVEL_ID,
      schema = ConstantsDB.OL_CM_PLATFORM,
      allocationSize = 1)
  @GeneratedValue(generator = "codLevel")
  @Column(name = "LEVEL_ID", nullable = false)
  private Long levelId;

  @Column(name = "LEVEL_NAME", length = ConstantsDB.CADENAS_50, unique = true, nullable = false)
  private String levelName;

  @Column(name = "SUB_LEVEL", nullable = false)
  private Long subLevel;

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
