package com.olympus.platform.util;

public class ConstantsDB {

  private ConstantsDB() {}

  // LONGITUDES DE BASE DE DATOS
  public static final int LONGITUD_ID_25 = 25;
  public static final int LONGITUD_PF_ID_27 = 27;
  public static final int TEL_LONG_20 = 20;
  public static final int LONGITUD_35_ID = 35;
  public static final int CADENAS_2 = 2;
  public static final int CADENAS_50 = 50;
  public static final int CADENAS_100 = 100;
  public static final int LARGE_CD_1K = 1000;
  public static final int LARGE_DESC_INFO_5K = 50000;
  public static final int LARGE_CD_32 = 32;
  public static final int LARGE_CD_16 = 16;
  public static final int PRECISION_4 = 4;
  public static final int SCALE_2 = 2;
  public static final int IP_ADRESS = 16;

  // FOREIG KEYS
  public static final String FK_OL_CM_AUDIT_USER = "FK_OL_CM_AUDIT_USER";
  public static final String FK_OL_CM_AUDIT_ACTION = "FK_OL_CM_AUDIT_ACTION";
  public static final String FK_OL_CM_SECURITY_KEY_USER = "FK_OL_CM_SECURITY_KEY_USER";
  public static final String FK_OL_CM_PROFILE_USER = "FK_OL_CM_PROFILE_USER";
  public static final String FK_OL_CM_PROFILE_COUNTRY = "FK_OL_CM_PROFILE_COUNTRY";

  // CAMPOS COMUNES ENTRE TABLAS
  public static final String CREATED_AT = "CREATED_AT";
  public static final String UPDATED_AT = "UPDATED_AT";
  public static final String DELETED_AT = "DELETED_AT";
  public static final String STATUS = "STATUS";

  // NOMBRES DE SCHEMAS
  public static final String OL_CM_SESSION = "ol_cm_session";
  public static final String OL_CM_SECURITY = "ol_cm_security";
  public static final String OL_CM_WELCOME = "ol_cm_welcome";
  public static final String OL_CM_OTHER = "ol_cm_other";
  public static final String OL_CM_PLATFORM = "ol_cm_platform";

  // NOMBRES DE TABLAS
  public static final String TB_USERTYPE = "tb_ol_cm_usertype";
  public static final String TB_USER = "tb_ol_cm_users";
  public static final String TB_WELCOME = "tb_ol_cm_welcome";
  public static final String TB_REPRESENTER = "tb_ol_cm_representer";
  public static final String TB_TEL = "tb_ol_cm_telephone";
  public static final String TB_PROFILE = "tb_ol_cm_profile";
  public static final String TB_ROLE = "tb_ol_cm_role";
  public static final String TB_SOCIAL = "tb_ol_cm_social";
  public static final String TB_COUNTRY = "tb_ol_cm_country";
  public static final String TB_STATUS = "tb_ol_cm_status";
  public static final String TB_MANAGEMENT = "tb_ol_cm_mg";
  public static final String TB_COMMUNITY_THEME = "tb_ol_cm_com_theme";
  public static final String TB_LEVEL = "tb_ol_cm_level";
  public static final String TB_AUDIT = "tb_ol_cm_audit";
  public static final String TB_ACTION_AUDIT = "tb_ol_cm_action";
  public static final String TB_KEYS = "tb_ol_cm_keys";
  public static final String TB_THEME = "tb_ol_cm_theme";
  public static final String TB_SUB_THEME = "tb_ol_cm_sub_theme";
  public static final String TB_COMMUNITY = "tb_ol_cm_community";
  public static final String TB_PROFILE_THEME = "tb_ol_cm_profile_theme";

  // TABLAS INTERMEDIAS
  public static final String TB_USER_USERTYPE = "tb_ol_cm_user_typeuser";

  // NOMBRE DE SECUENCIAS
  public static final String SC_OL_CM_WELCOME_ID = "SC_OL_CM_WELCOME_ID";
  public static final String SC_OL_CM_REPRESENTER_ID = "SC_OL_CM_REPRESENTER_ID";
  public static final String SC_OL_CM_TYPE_USER = "SC_OL_CM_TYPE_USER";
  public static final String SC_OL_CM_TEL_PROFILE = "SC_OL_CM_TEL_PROFILE";
  public static final String SC_OL_CM_COUNTRY_ID = "SC_OL_CM_COUNTRY_ID";
  public static final String SC_OL_CM_STATUS_ID = "SC_OL_CM_STATUS_ID";
  public static final String SC_OL_CM_COM_CAT_ID = "SC_OL_CM_COM_CAT_ID";
  public static final String SC_OL_CM_COM_PROF_ID = "SC_OL_CM_COM_PROF_ID";
  public static final String SC_OL_CM_LEVEL_ID = "SC_OL_CM_LEVEL_ID";
  public static final String SC_OL_CM_SECURITY_AUDIT = "SC_OL_CM_SECURITY_AUDIT";
  public static final String SC_OL_CM_SECURITY_ACTION = "SC_OL_CM_SECURITY_AUDIT";
  public static final String SC_OL_CM_SECURITY_KEYS = "SC_OL_CM_SECURITY_KEYS";
  public static final String SC_OL_CM_PROFILE_THEME = "SC_OL_CM_PROFILE_THEME";
}
