package com.olympus.empire.domain;

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
import com.olympus.empire.util.ConstantesDB;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_ol_cm_sub_themes", schema = "ol_cm_page")
@Entity
public class SubThemeEntity {
	
	@Id
	@SequenceGenerator(name = "codSubThemeId", sequenceName = "SC_OL_CM_SUB_THEME_ID", schema = "ol_cm_page", allocationSize = 1)
	@GeneratedValue(generator = "codSubThemeId")
	@Column(name = "SUB_THEME_ID", nullable = false)
	private Long subThemeId;
	
	@Column(name = "SUB_THEME_DESC", length = ConstantesDB.CADENAS_100, unique = true, nullable = false)
	private String subThemeDesc;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "THEME_ID", name = "THEME_ID", foreignKey = @ForeignKey(name = "FK_OL_CM_THEME_SUB_THEME"), nullable = false)
	private ThemeEntity theme;
	
}
