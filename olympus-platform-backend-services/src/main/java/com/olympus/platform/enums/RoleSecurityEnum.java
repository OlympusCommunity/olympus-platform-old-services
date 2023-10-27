package com.olympus.platform.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleSecurityEnum {
    ROLE_USER("ROLE_USER", 1L),
    ROLE_COMMUNITY("ROLE_COMMUNITY", 2L),
    ROLE_BUSINESS("ROLE_BUSINESS", 3L),
    ROLE_QUALITY("ROLE_QUALITY", 4L),
    ROLE_ADMIN("ROLE_ADMIN", 5L),
    ROLE_SUPERVISOR("ROLE_SUPERVISOR", 6L),
    ROLE_MASTER("ROLE_MASTER", 7L);

    private final String roleName;
    private final Long roleId;

}
