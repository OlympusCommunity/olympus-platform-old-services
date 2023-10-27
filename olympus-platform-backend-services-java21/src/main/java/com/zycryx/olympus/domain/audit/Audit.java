package com.zycryx.olympus.domain.audit;

import com.zycryx.olympus.domain.enums.ActionAuditEnum;
import com.zycryx.olympus.util.constants.DatabaseConstant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = DatabaseConstant.TB_AUDIT, schema = DatabaseConstant.OL_SECURITY)
@Entity
public class Audit {

    @Id
    @SequenceGenerator(
            name = "gen_audit",
            sequenceName = DatabaseConstant.SC_OL_CM_SECURITY_AUDIT,
            schema = DatabaseConstant.OL_SECURITY,
            allocationSize = 1)
    @GeneratedValue(generator = "gen_audit")
    @Column(name = DatabaseConstant.ID, nullable = false)
    private Long id;

    @Column(name = DatabaseConstant.ACTION, length = DatabaseConstant.VARCHAR_50, nullable = false)
    private ActionAuditEnum action;

    @Column(name = DatabaseConstant.BROWSER, length = DatabaseConstant.VARCHAR_100, nullable = true)
    private String browser;

    @Column(name = DatabaseConstant.IP_RECEIVER, length = DatabaseConstant.IP_ADDRESS, nullable = true)
    private String ipReceiver;

    @Column(name = DatabaseConstant.REASON, length = DatabaseConstant.VARCHAR_100, nullable = false)
    private String reason;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = DatabaseConstant.DATE, nullable = false)
    private Date date;

}
