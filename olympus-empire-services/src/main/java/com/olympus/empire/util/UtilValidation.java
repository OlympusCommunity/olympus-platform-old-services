package com.olympus.empire.util;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class UtilValidation {

	public static boolean isNotNull(Object object) {
		if (object == null) {
			log.info("Objeto Vacio");
		}
		return false;
	}

	public static Boolean isNull(Object object) {

		if (object == null) {
			return Boolean.TRUE;
		}
		else {
			return Boolean.FALSE;
		}
		
	}
	
	public static String isNullCompleted (String variable){
		
		String mensajeVacio = "";
		
		if (variable == null) {
			log.info("Objeto Vacio");
			return mensajeVacio;
		}
		else {
			return variable;
		}

	}

}
