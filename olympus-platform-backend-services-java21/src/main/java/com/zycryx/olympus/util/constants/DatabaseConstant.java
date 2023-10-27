package com.zycryx.olympus.util.constants;

public class DatabaseConstant {

    private DatabaseConstant() {}

    // LONGITUDES DE BASE DE DATOS
    public static final int ID_25 = 25;
    public static final int ID_27 = 27;
    public static final int ID_35 = 35;
    public static final int TEL_LONG_20 = 20;
    public static final int VARCHAR_2 = 2;
    public static final int VARCHAR_3 = 3;
    public static final int VARCHAR_50 = 50;
    public static final int VARCHAR_100 = 100;
    public static final int LARGE_VARCHAR_1K = 1000;
    public static final int LARGE_DESC_INFO_5K = 50000;
    public static final int VARCHAR_32 = 32;
    public static final int VARCHAR_16 = 16;
    public static final int PRECISION_4 = 4;
    public static final int SCALE_2 = 2;
    public static final int IP_ADDRESS = 16;

    // FOREIG KEYS
    public static final String FK_OL_AUDIT_USER = "FK_OL_AUDIT_USER";
    public static final String FK_OL_AUDIT_ACTION = "FK_OL_AUDIT_ACTION";
    public static final String FK_OL_SECURITY_KEY_USER = "FK_OL_SECURITY_KEY_USER";
    public static final String FK_OL_PROFILE_USER = "FK_OL_PROFILE_USER";
    public static final String FK_OL_PROFILE_COUNTRY = "FK_OL_PROFILE_COUNTRY";

    // NOMBRES DE SCHEMAS
    public static final String OL_SESSION = "ol_session";
    public static final String OL_SECURITY = "ol_security";
    public static final String OL_WELCOME = "ol_welcome";
    public static final String OL_PLATFORM = "ol_platform";

    // NOMBRES DE TABLAS
    public static final String TB_USERTYPE = "tb_usertype";
    public static final String TB_USER_ROLE = "tb_ol_cm_user_role";
    public static final String TB_USER = "tb_users";
    public static final String TB_ROLES_FOR_USERS = "tb_ol_cm_roles_for_users";
    public static final String TB_WELCOME = "tb_ol_cm_welcome";
    public static final String TB_REPRESENTATIVE = "tb_ol_cm_representative";
    public static final String TB_TEL = "tb_ol_cm_telephone";
    public static final String TB_PROFILE = "tb_ol_cm_profile";
    public static final String TB_ROLE = "tb_ol_cm_role";

    public static final String TB_LANGUAGE = "tb_ol_cm_user_language";
    public static final String TB_SOCIAL = "tb_ol_cm_social";
    public static final String TB_COUNTRY = "tb_ol_cm_country";
    public static final String TB_I18N = "tb_ol_cm_i18n";
    public static final String TB_STATUS = "tb_ol_cm_status";
    public static final String TB_MANAGEMENT = "tb_ol_cm_mg";
    public static final String TB_COMMUNITY_THEME = "tb_ol_cm_com_theme";
    public static final String TB_LEVEL = "tb_ol_cm_level";
    public static final String TB_AUDIT = "tb_ol_cm_audit";
    public static final String TB_ACTION_AUDIT = "tb_ol_cm_action";
    public static final String TB_KEYS = "tb_ol_cm_sc_keys";
    public static final String TB_MSN = "tb_ol_cm_sc_msn";
    public static final String TB_THEME = "tb_ol_cm_theme";
    public static final String TB_SUB_THEME = "tb_ol_cm_sub_theme";
    public static final String TB_COMMUNITY = "tb_ol_cm_community";
    public static final String TB_PROFILE_THEME = "tb_ol_cm_profile_theme";

    // TABLAS INTERMEDIAS
    public static final String TB_USER_ROLE_DESC = "tb_ol_cm_user_role_desc";

    // NOMBRE DE SECUENCIAS
    public static final String SC_OL_CM_WELCOME_ID = "SC_OL_CM_WELCOME_ID";
    public static final String SC_OL_CM_REPRESENTATIVE_ID = "SC_OL_CM_REPRESENTATIVE_ID";
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
    //GENERATION
    public static final String GEN_USER_ROLE = "gen_roles_for_users";
    public static final String SEQ_USER_ROLE = "seq_ol_cm_roles_for_users";

    //NOMBRE DE ATRIBUTOS Y CAMPOS DE BASE DE DATOS
    public static final String CREATED_AT = "CREATED_AT";
    public static final String UPDATED_AT = "UPDATED_AT";
    public static final String DELETED_AT = "DELETED_AT";
    public static final String STATUS = "STATUS";
    public static final String ID = "ID";
    public static final String USERNAME = "USERNAME";
    public static final String PASSWORD = "PASSWORD";
    public static final String EMAIL = "EMAIL";
    public static final String NICKNAME = "NICKNAME";
    public static final String ALIAS = "ALIAS";
    public static final String NAME = "NAME";
    public static final String SURNAME = "SURNAME";
    public static final String BIRTHDATE = "BIRTHDATE";
    public static final String SHORT_INFO = "SHORT_INFO";
    public static final String LONG_INFO = "LONG_INFO";
    public static final String PROFILE_PHOTO = "PROFILE_PHOTO";
    public static final String IMAGE_URL = "IMAGE_URL";
    public static final String USER_ROLE_NAME = "USER_ROLE_NAME";
    public static final String USER_ROLE_ALIAS = "USER_ROLE_ALIAS";
    public static final String USER_ROLE_DESC = "USER_ROLE_DESC";
    public static final String USER_ROLE_LANG = "USER_ROLE_LANG";
    public static final String IS_ACTIVE = "IS_ACTIVE";
    public static final String LIMIT = "LIMIT";
    public static final String ASSIGNED_AT = "ASSIGNED_AT";
    public static final String DEGRADED_AT = "DEGRADED_AT";
    public static final String ACTION = "ACTION";
    public static final String BROWSER = "BROWSER";
    public static final String IP_RECEIVER = "IP_RECEIVER";
    public static final String REASON = "REASON";
    public static final String DATE = "DATE";

}
