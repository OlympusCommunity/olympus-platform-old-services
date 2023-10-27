package com.olympus.platform.entity;

import com.olympus.platform.util.ConstantsDB;
import java.io.Serializable;
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
@Table(name = ConstantsDB.TB_USERTYPE, schema = ConstantsDB.OL_CM_SESSION)
@Entity
public class TypeUserEntity implements Serializable {

  @Id
  @SequenceGenerator(
      name = "scTypeUserId",
      sequenceName = ConstantsDB.SC_OL_CM_TYPE_USER,
      schema = ConstantsDB.OL_CM_SESSION,
      allocationSize = 1)
  @GeneratedValue(generator = "scTypeUserId")
  @Column(name = "TYPE_ID", nullable = false)
  private Long typeUserId;

  @Column(name = "TYPE_NAME", length = ConstantsDB.CADENAS_50, unique = true, nullable = false)
  private String typeUserName;

  @Column(name = "TYPE_DESC", length = ConstantsDB.LARGE_CD_1K, nullable = false)
  private String typeUserDesc;

  @Column(name = "ALIAS", length = ConstantsDB.CADENAS_50, unique = true, nullable = false)
  private String typeUserAlias;

  @Column(name = "TYPE_ABV", length = ConstantsDB.CADENAS_2, unique = true, nullable = true)
  private String typeUserAbv;

  @Column(name = "NUM_LIMIT", nullable = false)
  private Long typeUserNumLimit;

  private static final long serialVersionUID = 1L;
}
