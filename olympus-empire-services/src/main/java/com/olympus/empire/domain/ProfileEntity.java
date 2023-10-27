package com.olympus.empire.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.ForeignKey;
import com.olympus.empire.util.ConstantesDB;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_ol_cm_profiles", schema = "ol_cm_session")
@Entity
public class ProfileEntity {

	@Id
	@Column(name = "PROFILE_ID", nullable = false, length = ConstantesDB.LONGITUD_PF_ID)
	private String profileId;

	@Column(name = "NICKNAME", nullable = true, length = ConstantesDB.CADENAS_100)
	private String nickname;
	
	@Column(name = "ALIAS", nullable = true, length = ConstantesDB.CADENAS_50)
	private String alias;
	
	@Column(name = "PROF_NAME", nullable = false, length = ConstantesDB.CADENAS_50)
	private String name;

	@Column(name = "SURNAME", nullable = false, length = ConstantesDB.CADENAS_50)
	private String surname;

	@Column(name = "BIRTHDATE", nullable = true)
	private Date birthday;

	@Column(name = "INFO", nullable = true, length = ConstantesDB.CADENAS_50)
	private String info;

	@Column(name = "CITY", nullable = false, length = ConstantesDB.CADENAS_50)
	private String city;

	@Column(name = "STATUS", nullable = false)
	private Boolean status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_AT", nullable = false)
	private Date fechaCreacion;

	@Column(name = "UPDATE_AT", nullable = true)
	private Date fechaEdicion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "USER_ID", name = "USER_ID", foreignKey = @ForeignKey(name = "FK_OL_CM_PROFILE_USER"), nullable = false)
	private UserEntity user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "COUNTRY_ID", name = "COUNTRY_ID", foreignKey = @ForeignKey(name = "FK_OL_CM_PROFILE_COUNTRY"), nullable = false)
	private CountryEntity country;

}
