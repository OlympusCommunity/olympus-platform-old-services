package com.olympus.platform.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ActionAuditEnum {
    LOGIN(1L, "LOGIN"),
    LOGOUT(2L, "LOGOUT"),
    CREATE(3L, "CREATE"),
    READ(4L, "READ"),
    UPDATE(5L, "UPDATE"),
    DELETE(6L, "DELETE"),
    CANCEL(7L, "CANCEL"),
    OPTIONAL(8L, "OPTIONAL");

    private final Long actionId;
    private final String actionDesc;
}
