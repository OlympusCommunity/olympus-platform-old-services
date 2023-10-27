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
@Table(name = "tb_ol_cm_themes", schema = "ol_cm_page")
@Entity
public class ThemeEntity {
	
	@Id
	@SequenceGenerator(name = "codThemeId", sequenceName = "SC_OL_CM_THEME_ID", schema = "ol_cm_page", allocationSize = 1)
	@GeneratedValue(generator = "codThemeId")
	@Column(name = "THEME_ID", nullable = false)
	private Long themeId;
	
	@Column(name = "THEME_DESC", length = ConstantesDB.CADENAS_100, unique = true, nullable = false)
	private String themeDesc;

}
