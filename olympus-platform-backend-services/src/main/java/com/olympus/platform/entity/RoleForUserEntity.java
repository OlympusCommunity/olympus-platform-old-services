package com.olympus.platform.entity;

import com.olympus.platform.constants.DatabaseConstant;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name = DatabaseConstant.TB_ROLES_FOR_USERS, schema = DatabaseConstant.OL_CM_SESSION)
@Entity
public class RoleForUserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_roles_for_users")
    @SequenceGenerator(name = "gen_roles_for_users", sequenceName = "seq_ol_cm_roles_for_users", schema = DatabaseConstant.OL_CM_SESSION, allocationSize = 1)
    @Column(name = "ROLE_FOR_USER_ID", nullable = false)
    private Long roleForUserId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            referencedColumnName = "USER_ID",
            name = "USER_ID",
            foreignKey = @ForeignKey(name = "FK_USER_ROLES_FOR_USERS"),
            nullable = false)
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            referencedColumnName = "USER_ROLE_ID",
            name = "USER_ROLE_ID",
            foreignKey = @ForeignKey(name = "FK_USER_ROLE_ROLES_FOR_USERS"),
            nullable = false)
    private UserRoleEntity userRole;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ASSIGNED_AT", nullable = false)
    @Builder.Default
    private Date assignedAt = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DEGRADED_AT", nullable = true)
    private Date degradedAt;

}
