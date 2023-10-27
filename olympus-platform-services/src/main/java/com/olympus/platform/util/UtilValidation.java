package com.olympus.platform.util;

public class UtilValidation {

  private UtilValidation() {}

  public static Boolean validString(String cadena) {
    if (cadena == null || cadena.isEmpty() || cadena.equals("") || cadena.isBlank()) {
      return Boolean.FALSE;
    } else {
      return Boolean.TRUE;
    }
  }

  public static Boolean isNull(Object object) {

    if (object == null) {
      return Boolean.TRUE;
    } else {
      return Boolean.FALSE;
    }
  }

  public static String telInternational(String prefix, String tel) {
    return prefix + " " + tel;
  }
}
