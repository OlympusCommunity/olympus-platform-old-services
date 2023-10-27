package com.olympus.empire.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tb_ol_cm_users", schema = "ol_cm_session")
@Entity
public class UserEntity {

	@Id
	@Column(name = "USER_ID", nullable = false, length = ConstantesDB.LONGITUD_ID)
	private String userId;

	@Column(name = "USERNAME", nullable = false, length = ConstantesDB.CADENAS_50)
	private String username;

	@Column(name = "EMAIL", nullable = false, length = ConstantesDB.CADENAS_50)
	private String email;

	@Column(name = "SESSION_PASSWORD", nullable = false, length = ConstantesDB.LARGE_CD_1000)
	private String password;

	@Column(name = "STATUS", nullable = false)
	private Boolean status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_AT", nullable = false)
	private Date fechaCreacion;

	@Column(name = "UPDATE_AT", nullable = true)
	private Date fechaEdicion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "TYPE_ID", name = "TYPE_ID", foreignKey = @ForeignKey(name = "FK_OL_CM_USER_TYPE"), nullable = false)
	private TypeEntity typeEntity;

}
