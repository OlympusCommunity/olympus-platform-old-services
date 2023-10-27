package com.olympus.platform.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusEnum {
  CREATED(1L, "CREATED"),
  GENERATED(2L, "GENERATED"),
  ADMITTED(3L, "ADMITTED"),
  ACCEPTED(4L, "ACCEPTED"),
  PENDING(5L, "PENDING"),
  CANCELED(6L, "CANCELED"),
  BANNED(7L, "BANNED"),
  REMOVED(8L, "REMOVED"),
  DELETED(9L, "DELETED");

  private final Long statusId;
  private final String statusDesc;
}
