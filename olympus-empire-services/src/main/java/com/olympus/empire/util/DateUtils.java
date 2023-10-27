package com.olympus.empire.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class DateUtils {
	
	public static String formatoFecha (String fecha) throws ParseException {
		String fechaCompleta = fecha;
		SimpleDateFormat input = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date dateValue = input.parse(fechaCompleta);
		String pattern = "yyyy-MM-dd HH:mm:ss";
		DateFormat df = new SimpleDateFormat(pattern);
		String fechaFinal = df.format(dateValue);
		return fechaFinal;
	}
	
	public static Date convertStringToDate (String fecha) throws ParseException {
		if (fecha == null) {
			log.info("Objeto Vacio");
			return null;
		}
		else {
			SimpleDateFormat formato = new SimpleDateFormat(Constantes.FORMAT_DATE);
			return formato.parse(fecha);
		}
	}

	public static String convertDateToString (Date fecha) {
		if (fecha == null) {
			log.info("Objeto Vacio");
			return null;
		}
		else {
			SimpleDateFormat sdf = new SimpleDateFormat(Constantes.FORMAT_DATE);
			return sdf.format(fecha);
		}
	}

}
