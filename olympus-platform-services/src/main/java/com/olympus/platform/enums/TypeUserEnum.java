package com.olympus.platform.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypeUserEnum {
  MASTER(Long.valueOf(1)),
  ADMINISTRATOR(Long.valueOf(2)),
  QUALITY(Long.valueOf(3)),
  BUSINESS(Long.valueOf(4)),
  COMMUNITY(Long.valueOf(5)),
  PERSONAL(Long.valueOf(6));

  private final Long typeUserId;
}
