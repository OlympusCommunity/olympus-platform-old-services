package com.olympus.exception.emun;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ExceptionEnum {

	OK(Integer.valueOf(200)), 
	CREATED(Integer.valueOf(201)),
	ACEPTED(Integer.valueOf(202)),
	NO_CONTENT(Integer.valueOf(204)),
	NOT_FOUND(Integer.valueOf(404)), 
	BAD_REQUEST(Integer.valueOf(400)),
	CONFLICT(Integer.valueOf(409)),
	UNAUTHORIZED(Integer.valueOf(401)),
	FORBIDDEN(Integer.valueOf(403)),
	INTERNAL_SERVER_ERROR(Integer.valueOf(500));

	private final Integer httpStatus;

}
