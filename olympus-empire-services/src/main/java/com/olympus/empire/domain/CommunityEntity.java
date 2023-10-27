package com.olympus.empire.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "tb_ol_cm_communities", schema = "ol_cm_page")
@Entity
public class CommunityEntity {
	
	@Id
	@Column(name = "COMMUNITY_ID", nullable = false, length = ConstantesDB.LONGITUD_35_ID)
	private String communityId;
	
	@Column(name = "CM_NAME", length = ConstantesDB.LARGE_CD_1000, unique = true, nullable = false)
	private String cmName;

	@Column(name = "CM_DESC", length = ConstantesDB.LARGE_DESC_INFO, nullable = false)
	private String cmDesc;
	
	@Column(name = "CM_SCORE", precision = ConstantesDB.PRECISION_4, scale = ConstantesDB.SCALE_2, nullable = false)
	private BigDecimal cmScore;
	
	@Column(name = "CM_VIEWS", nullable = false)
	private Long cmViews;
	
	@Column(name = "STATUS", nullable = false)
	private Boolean status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_AT", nullable = false)
	private Date fechaCreacion;

	@Column(name = "UPDATE_AT", nullable = true)
	private Date fechaEdicion;
	
	@OneToMany(mappedBy = "community")
	Set<CommunityThemeEntity> communitiesCategories;

}
