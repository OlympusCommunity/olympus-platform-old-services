package com.olympus.platform.entity;

import com.olympus.platform.util.ConstantsDB;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = ConstantsDB.TB_USER, schema = ConstantsDB.OL_CM_SESSION)
@Entity
public class UserEntity implements Serializable {

  @Id
  @Column(name = "USER_ID", nullable = false, length = ConstantsDB.LONGITUD_ID_25)
  private String userId;

  @Column(name = "USERNAME", unique = true, nullable = false, length = ConstantsDB.CADENAS_50)
  private String username;

  @Column(name = "EMAIL", unique = true, nullable = false, length = ConstantsDB.CADENAS_50)
  private String email;

  @Column(name = "PASSWORD", nullable = false, length = ConstantsDB.LARGE_CD_1K)
  private String password;

  @Column(name = ConstantsDB.STATUS, nullable = false)
  private Boolean status;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = ConstantsDB.CREATED_AT, nullable = false)
  private Date creationDate;

  @Column(name = ConstantsDB.UPDATED_AT, nullable = true)
  private Date editionDate;

  @Column(name = ConstantsDB.DELETED_AT, nullable = true)
  private Date deleteDate;

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinTable(
      name = ConstantsDB.TB_USER_USERTYPE,
      schema = ConstantsDB.OL_CM_SESSION,
      joinColumns = @JoinColumn(name = "USER_ID", nullable = false),
      inverseJoinColumns = @JoinColumn(name = "TYPE_ID", nullable = false),
      uniqueConstraints = {@UniqueConstraint(columnNames = {"USER_ID", "TYPE_ID"})})
  private List<TypeUserEntity> userTypes;

  private static final long serialVersionUID = 1L;
}
