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
@Table(name = "tb_ol_cm_representer", schema = "ol_cm_web")
@Entity
public class RepresenterEntity {
	
	@Id
	@SequenceGenerator(name = "representerId", sequenceName = "SC_OL_CM_REPRESENTER_ID", schema = "ol_cm_web", allocationSize = 1)
	@GeneratedValue(generator = "representerId")
	@Column(name = "REPRESENTER_ID", nullable = false)
	private Long representerId;
	
	@Column(name = "REPRESENTER_NAME", length = ConstantesDB.CADENAS_50, unique = true, nullable = false)
	private String representerName;
	
	@Column(name = "REPRESENTER_IMG", unique = true, nullable = true)
	private byte[] representerImage;
	
	@Column(name = "REPRESENTER_ROLE", length = ConstantesDB.CADENAS_50, nullable = true)
	private String representerRole;
	
	@Column(name = "REPRESENTER_DESC", length = ConstantesDB.LARGE_CD_1000, nullable = true)
	private String representerDesc;
	
	@Column(name = "STATUS", nullable = false)
	private Boolean status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_AT", nullable = false)
	private Date fechaCreacion;

	@Column(name = "UPDATE_AT", nullable = true)
	private Date fechaEdicion;

}
