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
@Table(name = "tb_ol_cm_socials", schema = "ol_cm_page")
@Entity
public class SocialNetworkEntity {
	
	@Id
	@SequenceGenerator(name = "codComCat", sequenceName = "SC_OL_CM_COM_CAT_ID", schema = "ol_cm_security",  allocationSize = 1)
	@GeneratedValue(generator = "codComCat")
	@Column(name = "SOCIAL_ID", nullable = false)
	private Long socialId;
	
	@Column(name = "SOCIAL_NAME", length = ConstantesDB.CADENAS_50, unique = true, nullable = false)
	private String socialName;

}
