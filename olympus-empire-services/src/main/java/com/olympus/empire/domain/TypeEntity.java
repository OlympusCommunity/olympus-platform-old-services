package com.olympus.empire.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.olympus.empire.util.ConstantesDB;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_ol_cm_types", schema = "ol_cm_session")
@Entity
public class TypeEntity {

	@Id
	@SequenceGenerator(name = "codTypeUser", sequenceName = "SC_OL_CM_TYPE_USER", schema = "ol_cm_session", allocationSize = 1)
	@GeneratedValue(generator = "codTypeUser")
	@Column(name = "TYPE_ID", nullable = false)
	private Long typeId;

	@Column(name = "TYPE_NAME", length = ConstantesDB.CADENAS_50, unique = true, nullable = false)
	private String name;
	
	@Column(name = "ALIAS", length = ConstantesDB.CADENAS_2, unique = true, nullable = false)
	private String alias;

	@Column(name = "NUM_LIMIT", nullable = false)
	private Long numLimit;

}
