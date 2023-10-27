package com.olympus.platform.entity;

import com.olympus.platform.constants.DatabaseConstant;
import com.olympus.platform.enums.ActionAuditEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = DatabaseConstant.TB_AUDIT, schema = DatabaseConstant.OL_CM_SECURITY)
@Entity
public class AuditEntity implements Serializable {

    @Id
    @SequenceGenerator(
            name = "gen_audit",
            sequenceName = DatabaseConstant.SC_OL_CM_SECURITY_AUDIT,
            schema = DatabaseConstant.OL_CM_SECURITY,
            allocationSize = 1)
    @GeneratedValue(generator = "gen_audit")
    @Column(name = "AUDIT_ID", nullable = false)
    private Long auditId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            referencedColumnName = "USER_ID",
            name = "USER_ID",
            foreignKey = @ForeignKey(name = DatabaseConstant.FK_OL_CM_AUDIT_USER),
            nullable = false)
    private UserEntity user;

    @Column(name = "ACTION_DESC", length = DatabaseConstant.CADENAS_50, nullable = false)
    private ActionAuditEnum actionDesc;

    @Column(name = "BROWSER", length = DatabaseConstant.CADENAS_100, nullable = true)
    private String browser;

    @Column(name = "IP_RECEIVER", length = DatabaseConstant.IP_ADRESS, nullable = true)
    private String ipReceiver;

    @Column(name = "REASON", length = DatabaseConstant.CADENAS_100, nullable = false)
    private String reason;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE", nullable = false)
    private Date date;

    private static final long serialVersionUID = 1L;
}
