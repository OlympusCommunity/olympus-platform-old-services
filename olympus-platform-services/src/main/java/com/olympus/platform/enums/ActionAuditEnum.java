package com.olympus.platform.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ActionAuditEnum {
  LOGIN(Long.valueOf(1)),
  LOGOUT(Long.valueOf(2)),
  CREATE(Long.valueOf(3)),
  READ(Long.valueOf(4)),
  UPDATE(Long.valueOf(5)),
  DELETE(Long.valueOf(6)),
  CANCEL(Long.valueOf(7)),
  OPTIONAL(Long.valueOf(8));

  private final Long actionId;
}
