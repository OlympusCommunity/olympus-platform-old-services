package com.olympus.platform.model.user;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
@EqualsAndHashCode
public class UserGetRequestFilterDTO {
    private String userId;
    private String userName;
    private String nickname;
    private String alias;
    private String name;
    private String surname;
    private Date birthday;
    private String shortInfo;
    private String longInfo;
    private String imageUrl;
    private String email;
    private String password;
    private Boolean activeAccount;
    private Boolean status;
    private Date creationDate;
    private Date editionDate;
    private Date deleteDate;
}
