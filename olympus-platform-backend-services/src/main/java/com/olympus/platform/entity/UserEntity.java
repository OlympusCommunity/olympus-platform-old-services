package com.olympus.platform.entity;

import com.olympus.platform.constants.DatabaseConstant;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name = DatabaseConstant.TB_USER, schema = DatabaseConstant.OL_CM_SESSION)
@Entity
public class UserEntity implements Serializable {

    @Id
    @Column(name = "USER_ID", nullable = false, length = DatabaseConstant.LONGITUD_ID_25)
    private String userId;

    @Column(name = "USERNAME", unique = true, nullable = false, length = DatabaseConstant.CADENAS_50)
    private String userName;

    @Column(name = "NICKNAME", nullable = true, unique = true, length = DatabaseConstant.CADENAS_100)
    private String nickname;

    @Column(name = "ALIAS", nullable = true, length = DatabaseConstant.CADENAS_50)
    private String alias;

    @Column(name = "NAME", nullable = true, length = DatabaseConstant.CADENAS_50)
    private String name;

    @Column(name = "SURNAME", nullable = true, length = DatabaseConstant.CADENAS_50)
    private String surname;

    @Column(name = "BIRTHDATE", nullable = true)
    private Date birthday;

    @Column(name = "SHORT_INFO", nullable = true, length = DatabaseConstant.LARGE_CD_1K)
    private String shortInfo;

    @Column(name = "LONG_INFO", nullable = true, length = DatabaseConstant.LARGE_DESC_INFO_5K)
    private String longInfo;

    @Column(name = "PROFILE_PHOTO", nullable = true)
    private byte[] image;

    @Column(name = "IMAGE_URL", nullable = true, length = DatabaseConstant.LARGE_CD_1K)
    private String imageUrl;

    @Column(name = "EMAIL", unique = true, nullable = false, length = DatabaseConstant.CADENAS_50)
    private String email;

    @Column(name = "PASSWORD", nullable = false, length = DatabaseConstant.LARGE_CD_1K)
    private String password;

    @Column(name = "ACTIVE_ACCOUNT", nullable = false)
    @Builder.Default
    private Boolean activeAccount = Boolean.FALSE;

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
            foreignKey = @ForeignKey(name = "FK_OL_CM_USER_COUNTRY"),
            nullable = false)
    private CountryEntity country;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<RoleForUserEntity> roleForUser;

}
