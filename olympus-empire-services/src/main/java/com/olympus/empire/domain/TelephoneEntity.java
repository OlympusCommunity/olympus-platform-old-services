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
@Table(name = "tb_ol_cm_telephones", schema = "ol_cm_session")
@Entity
public class TelephoneEntity {

	@Id
	@SequenceGenerator(name = "idAdmTelSeqGenerator", sequenceName = "SC_OL_CM_TEL_PROFILE", schema = "ol_cm_session", allocationSize = 1)
	@GeneratedValue(generator = "idAdmTelSeqGenerator")
	@Column(name = "TEL_ID", nullable = false)
	private Long telId;

	@Column(name = "NUM_TEL", length = ConstantesDB.TEL_LONG, nullable = false)
	private String numTel;

	@Column(name = "STATUS", nullable = false)
	private Boolean status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_AT", nullable = false)
	private Date fechaCreacion;

	@Column(name = "UPDATE_AT", nullable = true)
	private Date fechaEdicion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "PROFILE_ID", name = "PROFILE_ID", foreignKey = @ForeignKey(name = "FK_OL_CM_TEL_PROFILE"), nullable = false)
	private ProfileEntity profile;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "COUNTRY_ID", name = "COUNTRY_ID", foreignKey = @ForeignKey(name = "FK_OL_CM_TEL_COUNTRY"), nullable = false)
	private CountryEntity country;

}
