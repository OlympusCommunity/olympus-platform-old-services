package com.olympus.platform.entity;

import com.olympus.platform.util.ConstantsDB;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = ConstantsDB.TB_SOCIAL, schema = ConstantsDB.OL_CM_PLATFORM)
@Entity
public class SocialNetworkEntity {

  @Id
  @SequenceGenerator(
      name = "codComCat",
      sequenceName = "SC_OL_CM_COM_CAT_ID",
      schema = ConstantsDB.OL_CM_PLATFORM,
      allocationSize = 1)
  @GeneratedValue(generator = "codComCat")
  @Column(name = "SOCIAL_ID", nullable = false)
  private Long socialId;

  @Column(name = "SOCIAL_BUTTON", length = ConstantsDB.CADENAS_50, nullable = false)
  private String socialPtButton;

  @Column(name = "SOCIAL_NAME", length = ConstantsDB.CADENAS_50, unique = true, nullable = false)
  private String socialName;
}
