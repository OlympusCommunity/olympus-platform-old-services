package com.olympus.platform.entity;

import com.olympus.platform.constants.DatabaseConstant;
import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name = DatabaseConstant.TB_LANGUAGE, schema = DatabaseConstant.OL_CM_OTHER)
@Entity
public class LanguageEntity {

    @Id
    @Column(name = "LANG_CODE_ID", nullable = false, length = DatabaseConstant.CADENAS_2)
    private String langCodeId;

    @Column(name = "LANG_NAME", unique = true, nullable = false, length = DatabaseConstant.CADENAS_50)
    private String langName;

}
