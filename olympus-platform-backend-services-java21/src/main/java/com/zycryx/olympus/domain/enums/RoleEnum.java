package com.zycryx.olympus.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleEnum {
    MASTER(1L, "MASTER"),
    ADMIN(2L, "ADMIN"),
    PERSONAL(3L, "PERSONAL"),
    COMMUNITY(4L, "COMMUNITY"),
    BUSINESS(5L, "BUSINESS"),
    MERCHANT(6L, "MERCHANT"),
    QUALITY(7L, "QUALITY"),
    CUSTOMER(8L, "CUSTOMER"),
    OTHER(9L, "OTHER");

    private final Long roleId;
    private final String roleDesc;
}
