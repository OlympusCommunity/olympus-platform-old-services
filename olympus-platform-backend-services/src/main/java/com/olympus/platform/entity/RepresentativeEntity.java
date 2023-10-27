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
@Table(name = DatabaseConstant.TB_REPRESENTATIVE, schema = DatabaseConstant.OL_CM_WELCOME)
@Entity
public class RepresentativeEntity implements Serializable {

  @Id
  @SequenceGenerator(
      name = "gen_representative",
      sequenceName = DatabaseConstant.SC_OL_CM_REPRESENTATIVE_ID,
      schema = DatabaseConstant.OL_CM_WELCOME,
      allocationSize = 1)
  @GeneratedValue(generator = "gen_representative")
  @Column(name = "representative_ID", nullable = false)
  private Long representativeId;

  @Column(
      name = "representative_NAME",
      length = DatabaseConstant.CADENAS_50,
      unique = true,
      nullable = false)
  private String representativeName;

  @Column(name = "representative_IMG", unique = true)
  private byte[] representativeImage;

  @Column(name = "representative_ROLE", length = DatabaseConstant.CADENAS_50)
  private String representativeRole;

  @Column(name = "representative_DESC", length = DatabaseConstant.LARGE_CD_1K)
  private String representativeDesc;

  @Column(name = "representative_LANG", length = DatabaseConstant.CADENAS_2)
  private String representativeLang;

  @Column(name = "STATUS", nullable = false)
  private Boolean status;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = DatabaseConstant.CREATED_AT, nullable = false)
  private Date creationDate;

  @Column(name = DatabaseConstant.UPDATED_AT)
  private Date editionDate;

  @Column(name = DatabaseConstant.DELETED_AT)
  private Date deleteDate;
}
