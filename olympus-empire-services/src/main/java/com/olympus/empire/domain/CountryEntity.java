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
@Table(name = "tb_ol_cm_countries", schema = "ol_cm_other")
@Entity
public class CountryEntity {
	
	@Id
	@SequenceGenerator(name = "codCountryId", sequenceName = "SC_OL_CM_COUNTRY_ID", schema = "ol_cm_other", allocationSize = 1)
	@GeneratedValue(generator = "codCountryId")
	@Column(name = "COUNTRY_ID", nullable = false)
	private Long countryId;
	
	@Column(name = "COUNTRY_NAME", length = ConstantesDB.CADENAS_50, unique = true, nullable = false)
	private String countryName;
	
	@Column(name = "ABV", length = ConstantesDB.PRECISION_4, unique = true, nullable = false)
	private String abv;
	
	@Column(name = "PREF_TEL", length = ConstantesDB.PRECISION_4, nullable = false)
	private String prefTel;

}
