package com.olympus.empire.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = "tb_ol_cm_roles", schema = "ol_cm_page")
@Entity
public class RoleEntity {
	
	@Id
	@SequenceGenerator(name = "codRole", sequenceName = "SC_OL_CM_ROLE_ID", schema = "ol_cm_page", allocationSize = 1)
	@GeneratedValue(generator = "codRole")
	@Column(name = "ROLE_ID", nullable = false)
	private Long roleId;
	
	@Column(name = "ROLE_NAME", length = ConstantesDB.CADENAS_50, unique = true, nullable = false)
	private String roleName;
	
	@Column(name = "ROLE_DESC", length = ConstantesDB.LARGE_CD_1000, nullable = false)
	private String roleDesc;
	
	@Column(name = "STATUS", nullable = false)
	private Boolean status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_AT", nullable = false)
	private Date fechaCreacion;

	@Column(name = "UPDATE_AT", nullable = true)
	private Date fechaEdicion;

}
