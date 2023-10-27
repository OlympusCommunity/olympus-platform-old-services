package com.olympus.platform.entity;

import com.olympus.platform.constants.DatabaseConstant;
import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name = DatabaseConstant.TB_TEL, schema = DatabaseConstant.OL_CM_SESSION)
@Entity
public class TelephoneEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_telephone")
    @SequenceGenerator(name = "gen_telephone", sequenceName = "seq_ol_cm_telephone", schema = DatabaseConstant.OL_CM_SESSION, allocationSize = 1)
    @Column(name = "TEL_ID", nullable = false)
    private Long telId;

    @Column(name = "NUM_TEL", length = DatabaseConstant.TEL_LONG_20, nullable = false)
    private String numTel;

    @Column(name = DatabaseConstant.STATUS, nullable = false)
    @Builder.Default
    private Boolean status = Boolean.TRUE;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = DatabaseConstant.CREATED_AT, nullable = false)
    @Builder.Default
    private Date creationDate = new Date();

    @Column(name = DatabaseConstant.UPDATED_AT, nullable = true)
    private Date editionDate;

    @Column(name = DatabaseConstant.DELETED_AT, nullable = true)
    private Date deleteDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            referencedColumnName = "COUNTRY_ID",
            name = "COUNTRY_ID",
            foreignKey = @ForeignKey(name = "FK_OL_CM_TEL_COUNTRY"),
            nullable = false)
    private CountryEntity country;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            referencedColumnName = "USER_ID",
            name = "USER_ID",
            foreignKey = @ForeignKey(name = "FK_OL_CM_TEL_USER"),
            nullable = false)
    private UserEntity user;
}
