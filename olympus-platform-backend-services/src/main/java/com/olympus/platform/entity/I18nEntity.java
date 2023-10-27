package com.olympus.platform.entity;

import com.olympus.platform.constants.DatabaseConstant;
import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name = DatabaseConstant.TB_I18N, schema = DatabaseConstant.OL_CM_OTHER)
@Entity
public class I18nEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_country")
    @SequenceGenerator(
            name = "gen_i18n",
            sequenceName = "seq_ol_cm_i18n",
            schema = DatabaseConstant.OL_CM_OTHER,
            allocationSize = 1)
    @Column(name = "i18n_id", nullable = false)
    private Long i18nId;

    private String key;

    private String value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            referencedColumnName = "LANG_CODE_ID",
            name = "LANG_CODE_ID",
            foreignKey = @ForeignKey(name = "FK_OL_CM_I118N_LANG"),
            nullable = false)
    private LanguageEntity lang;
}
