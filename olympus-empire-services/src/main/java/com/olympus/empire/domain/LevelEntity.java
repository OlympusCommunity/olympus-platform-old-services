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
@Table(name = "tb_ol_cm_levels", schema = "ol_cm_page")
@Entity
public class LevelEntity {
	
	@Id
	@SequenceGenerator(name = "codLevel", sequenceName = "SC_OL_CM_LEVEL_ID", schema = "ol_cm_page", allocationSize = 1)
	@GeneratedValue(generator = "codLevel")
	@Column(name = "LEVEL_ID", nullable = false)
	private Long levelId;
	
	@Column(name = "LEVEL_NAME", length = ConstantesDB.CADENAS_50, unique = true, nullable = false)
	private String levelName;
	
	@Column(name = "SUB_LEVEL", nullable = false)
	private Long subLevel;

	@Column(name = "STATUS", nullable = false)
	private Boolean status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_AT", nullable = false)
	private Date fechaCreacion;

	@Column(name = "UPDATE_AT", nullable = true)
	private Date fechaEdicion;

}
