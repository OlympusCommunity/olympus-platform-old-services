package com.olympus.platform.entity;

import com.olympus.platform.constants.DatabaseConstant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name = DatabaseConstant.TB_USER_ROLE, schema = DatabaseConstant.OL_CM_SESSION)
@Entity
public class UserRoleEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_user_role")
    @SequenceGenerator(name = "gen_user_role", sequenceName = "seq_ol_cm_user_role", schema = DatabaseConstant.OL_CM_SESSION, allocationSize = 1)
    @Column(name = "USER_ROLE_ID", nullable = false)
    private Long userRoleId;

    @Column(name = "USER_ROLE_NAME", unique = true, nullable = false, length = DatabaseConstant.CADENAS_50)
    private String userRoleName;

    @Column(name = "USER_ROLE_ALIAS", unique = true, nullable = false)
    private String userRoleAlias;

    @Column(name = "USER_ROLE_DESC", nullable = false, length = DatabaseConstant.LARGE_CD_1K)
    private String userRoleDesc;

    @Column(name = "USER_ROLE_LANG", nullable = false, length = DatabaseConstant.LARGE_CD_16)
    private String userRoleLang;

    @Column(name = "USER_ROLE_LIMIT", nullable = false)
    private Long userRoleLimit;

    @OneToMany(mappedBy = "userRole", cascade = CascadeType.ALL)
    private Set<RoleForUserEntity> roleForUser;
}
