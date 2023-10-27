package com.olympus.platform.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusEnum {
  CREATED(Long.valueOf(1)),
  GENERATED(Long.valueOf(2)),
  ADMITED(Long.valueOf(3)),
  PENDING(Long.valueOf(4)),
  CANCELED(Long.valueOf(5)),
  BANNED(Long.valueOf(6)),
  REMOVED(Long.valueOf(7));

  private final Long statusId;
}
