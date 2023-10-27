package com.zycryx.olympus.domain.session;

import com.zycryx.olympus.util.constants.DatabaseConstant;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name = DatabaseConstant.TB_USER_ROLE, schema = DatabaseConstant.OL_SESSION)
@Entity
public class UserRoleSession {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = DatabaseConstant.GEN_USER_ROLE)
    @SequenceGenerator(name = "gen_roles_for_users", sequenceName = DatabaseConstant.SEQ_USER_ROLE, schema = DatabaseConstant.OL_SESSION, allocationSize = 1)
    @Column(name = DatabaseConstant.ID, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            referencedColumnName = DatabaseConstant.ID,
            name = DatabaseConstant.ID,
            foreignKey = @ForeignKey(name = "FK_USER_ROLES_FOR_USERS"),
            nullable = false)
    private UserSession user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            referencedColumnName = DatabaseConstant.ID,
            name = DatabaseConstant.ID,
            foreignKey = @ForeignKey(name = "FK_USER_ROLE_ROLES_FOR_USERS"),
            nullable = false)
    private RoleSession role;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = DatabaseConstant.ASSIGNED_AT, nullable = false)
    @Builder.Default
    private Date assignedAt = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = DatabaseConstant.DEGRADED_AT, nullable = true)
    private Date degradedAt;
    
}
