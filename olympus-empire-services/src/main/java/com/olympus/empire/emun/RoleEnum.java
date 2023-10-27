package com.olympus.empire.emun;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RoleEnum {
	
	FOUNDER(Long.valueOf(1)),
	PARTICIPANT(Long.valueOf(2)),
	DEFAULT(Long.valueOf(3)),
	BANNED(Long.valueOf(4)),
	DELETE(Long.valueOf(5));

	private final Long roleId;

}
