package com.zycryx.olympus.domain.session;

import com.zycryx.olympus.domain.enums.RoleEnum;
import com.zycryx.olympus.util.constants.DatabaseConstant;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name = DatabaseConstant.TB_USER_ROLE, schema = DatabaseConstant.OL_SESSION)
@Entity
public class RoleSession {

    @Id
    @Column(name = DatabaseConstant.ID, nullable = false, length = DatabaseConstant.ID_25)
    private String id;

    @Column(name = DatabaseConstant.SHORT_INFO , nullable = false, length = DatabaseConstant.LARGE_VARCHAR_1K)
    private String shortInfo;

    @Column(name = DatabaseConstant.LIMIT , nullable = false)
    private Long limit;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private Set<UserRoleSession> role;

}
