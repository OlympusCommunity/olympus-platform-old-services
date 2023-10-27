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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_ol_cm_com_themes", schema = "ol_cm_page")
@Entity
public class CommunityThemeEntity {
	
	@Id
	@SequenceGenerator(name = "codComCat", sequenceName = "SC_OL_CM_COM_CAT_ID", schema = "ol_cm_page", allocationSize = 1)
	@GeneratedValue(generator = "codComCat")
	@Column(name = "COM_CAT_ID", nullable = false)
	private Long comCatId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "COMMUNITY_ID", name = "COMMUNITY_ID", foreignKey = @ForeignKey(name = "FK_OL_CM_COMMUNITY_THEME"), nullable = false)
	private CommunityEntity community;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "THEME_ID", name = "THEME_ID", foreignKey = @ForeignKey(name = "FK_OL_CM_THEME_COMMUNITY"), nullable = false)
	private ThemeEntity theme;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "SUB_THEME_ID", name = "SUB_THEME_ID", foreignKey = @ForeignKey(name = "FK_OL_CM_THEME_COMMUNITY_SUB_THEME"), nullable = false)
	private SubThemeEntity subTheme;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_AT", nullable = false)
	private Date fechaCreacion;
	
	@Column(name = "UPDATE_AT", nullable = true)
	private Date fechaEdicion;

}
