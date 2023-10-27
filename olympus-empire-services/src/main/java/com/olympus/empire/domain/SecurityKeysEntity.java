package com.olympus.empire.domain;

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
import com.olympus.empire.util.ConstantesDB;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_ol_cm_keys", schema = "ol_cm_security")
@Entity
public class SecurityKeysEntity {
	
	@Id
	@SequenceGenerator(name = "codSecurityKeys", sequenceName = "SC_OL_CM_SECURITY_KEYS", schema = "ol_cm_page", allocationSize = 1)
	@GeneratedValue(generator = "codSecurityKeys")
	@Column(name = "ID_SK", nullable = false)
	private Long codSecurityKey;
	
	@Column(name = "KEY_PASS", length = ConstantesDB.LARGE_CD_1000, unique = true, nullable = false)
	private String keyPass;
	
	@Column(name = "IV_KEY", length = ConstantesDB.LARGE_CD_16, unique = true, nullable = false)
	private String ivKey;
	
	@Column(name = "SALT_KEY", length = ConstantesDB.LARGE_CD_32, unique = true, nullable = false)
	private String saltKey;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_AT", nullable = false)
	private Date fechaCreacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "USER_ID", name = "USER_ID", foreignKey = @ForeignKey(name = "FK_OL_CM_PROFILE_USER"), nullable = false)
	private UserEntity user;

}
