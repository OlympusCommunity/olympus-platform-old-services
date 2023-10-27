package com.zycryx.olympus.domain.session;

import com.zycryx.olympus.domain.enums.StatusEnum;
import com.zycryx.olympus.util.constants.DatabaseConstant;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name = DatabaseConstant.TB_USER_ROLE, schema = DatabaseConstant.OL_SESSION)
@Entity
public class UserSession {

    @Id
    @Column(name = DatabaseConstant.ID, nullable = false, length = DatabaseConstant.ID_25)
    private String id;

    @Column(name = DatabaseConstant.USERNAME, unique = true, nullable = false, length = DatabaseConstant.LARGE_VARCHAR_1K)
    private String username;

    @Column(name = DatabaseConstant.PASSWORD, nullable = false, length = DatabaseConstant.LARGE_VARCHAR_1K)
    private String password;

    @Column(name = DatabaseConstant.EMAIL, unique = true, nullable = false, length = DatabaseConstant.VARCHAR_50)
    private String email;

    @Column(name = DatabaseConstant.NICKNAME, unique = true, length = DatabaseConstant.VARCHAR_100)
    private String nickname;

    @Column(name = DatabaseConstant.ALIAS, length = DatabaseConstant.VARCHAR_100)
    private String alias;

    @Column(name = DatabaseConstant.NAME, length = DatabaseConstant.VARCHAR_50)
    private String name;

    @Column(name = DatabaseConstant.SURNAME, length = DatabaseConstant.VARCHAR_50)
    private String surname;

    @Column(name = DatabaseConstant.BIRTHDATE)
    private Date birthdate;

    @Column(name = DatabaseConstant.SHORT_INFO, length = DatabaseConstant.LARGE_VARCHAR_1K)
    private String shortInfo;

    @Column(name = DatabaseConstant.LONG_INFO, length = DatabaseConstant.LARGE_DESC_INFO_5K)
    private String longInfo;

    @Column(name = DatabaseConstant.PROFILE_PHOTO)
    private byte[] image;

    @Column(name = DatabaseConstant.IMAGE_URL, length = DatabaseConstant.LARGE_VARCHAR_1K   )
    private String imageUrl;

    @Column(name = DatabaseConstant.IS_ACTIVE, nullable = false)
    private Boolean isActive = Boolean.FALSE;

    @Column(name = DatabaseConstant.STATUS, nullable = false)
    private StatusEnum status = StatusEnum.CREATED;

    @Column(name = DatabaseConstant.CREATED_AT, nullable = false)
    private Date createdAt = new Date();

    @Column(name = DatabaseConstant.UPDATED_AT)
    private Date updatedAt;

    @Column(name = DatabaseConstant.DELETED_AT)
    private Date deletedAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserRoleSession> userRole;

}