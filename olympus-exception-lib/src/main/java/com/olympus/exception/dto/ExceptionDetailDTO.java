package com.olympus.exception.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ExceptionDetailDTO {

	private Integer httpStatus;
	private String exception;
	private Date fecha;
	private String mensaje;
	private String detalle;
	private String trace;

}
