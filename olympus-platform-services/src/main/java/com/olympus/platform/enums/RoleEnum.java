package com.olympus.platform.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RoleEnum {
  FOUNDER(1L),
  PARTICIPANT(2L),
  DEFAULT(3L),
  BANNED(4L),
  DELETE(5L);

  private final Long roleId;
}
