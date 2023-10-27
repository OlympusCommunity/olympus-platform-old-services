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
@Table(name = ConstantsDB.TB_COUNTRY, schema = ConstantsDB.OL_CM_OTHER)
@Entity
public class CountryEntity {

  @Id
  @SequenceGenerator(
      name = "codCountryId",
      sequenceName = ConstantsDB.SC_OL_CM_COUNTRY_ID,
      schema = ConstantsDB.OL_CM_OTHER,
      allocationSize = 1)
  @GeneratedValue(generator = "codCountryId")
  @Column(name = "COUNTRY_ID", nullable = false)
  private Long countryId;

  @Column(name = "COUNTRY_NAME", length = ConstantsDB.CADENAS_50, unique = true, nullable = false)
  private String countryName;

  @Column(name = "ABV", length = ConstantsDB.PRECISION_4, unique = true, nullable = false)
  private String abv;

  @Column(name = "PREF_TEL", length = ConstantsDB.PRECISION_4, nullable = false)
  private String prefTel;
}
