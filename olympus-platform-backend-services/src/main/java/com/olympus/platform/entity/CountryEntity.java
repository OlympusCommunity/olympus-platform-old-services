package com.olympus.platform.entity;

import com.olympus.platform.constants.DatabaseConstant;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name = DatabaseConstant.TB_COUNTRY, schema = DatabaseConstant.OL_CM_OTHER)
@Entity
public class CountryEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_country")
    @SequenceGenerator(
            name = "gen_country",
            sequenceName = "seq_ol_cm_country",
            schema = DatabaseConstant.OL_CM_OTHER,
            allocationSize = 1)
    @Column(name = "COUNTRY_ID", nullable = false)
    private Long countryId;

    @Column(name = "COUNTRY_NAME", unique = true, nullable = false, length = DatabaseConstant.CADENAS_50)
    private String countryName;

    @Column(name = "COUNTRY_ALIAS", unique = true, nullable = false, length = DatabaseConstant.CADENAS_3)
    private String countryAlias;

    @Column(name = "COUNTRY_PREF", nullable = false, length = DatabaseConstant.PRECISION_4)
    private String countryPref;
}
