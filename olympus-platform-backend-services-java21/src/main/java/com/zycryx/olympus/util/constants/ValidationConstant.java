package com.zycryx.olympus.util.constants;

public class ValidationConstant {

    private ValidationConstant() {};

    // MENSAJES DE VALIDACION
    public static final String MESSAGE_NOT_NULL = " must not be null.";
    public static final String MESSAGE_NOT_EMPTY = " must not be empty.";
    public static final String MESSAGE_NOT_BLANK = " must not be blank.";
    public static final String MESSAGE_WRONG_EMAIL = "Wrong email.";

    // MENSAJE DE LOGS
    public static final String START_SERVICE = " - LOGGING START SERVICE";
    public static final String PROCESS_SERVICE = " - LOGGING PROCESS SERVICE";
    public static final String FINAL_SERVICE = " - LOGGING FINAL SERVICE";

    // MENSAJE DE ENCRIPTACION
    public static final String WELCOME = "Bienvenido al sistema ";
    public static final String ERROR_WELCOME =
            "Credenciales incorrectas, usuario y/o contraseña incorrectas";
    public static final String ERROR_TYPEUSER = "No se encontró el tipo de usuario";
    public static final String ERROR_USER = "Usuario o Email incorrecto";
    public static final String ERROR_PASSWORD = "Contraseña incorrecta";
    public static final String USER_ALREADY_EXISTS = "Username already exists.";
    public static final String USER_NOT_FOUND = "User not found.";
    public static final String PASSWORD_REPEAT = "The entered passwords do not match. Try again.";
    public static final String PASSWORD_INCORRECT = "Password with incorrect characters.";
    public static final String USER_TYPE_NOT_FOUND = "User types not found in the database.";
    public static final String PASSWORD_NOT_FOUND = "Password or Repeat password is not found.";
    public static final String ROLE_NOT_FOUND = "Roles for User not found.";
    public static final String ROLE_UPDATE = "The roles for user was successfully registered.";
    public static final String AES_ENCRIPT = "AES";
    public static final String AES_STRING = "AES/CBC/PKCS5PADDING";
    public static final String UTF_8 = "UTF-8";
    public static final String PASS_ENCRYPT = "Starting encriptyn of passwords";
    public static final String PROFILE_ABV = "PF";
    public static final int LONG_SECURITY_KEYS_32 = 32;
    public static final int LONG_SECURITY_KEYS_16 = 16;
    public static final int LONG_IV_256 = 256;
    public static final String ALL_CHAR =
            "ABCDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnñopqrstuvxyz0123456789|°!#$%&/()=?¡¿'¬´+{},.-¨*[];:_~^`*<>";
    public static final String FORMAT_DATE = "dd-MM-yyyy HH:mm:ss";

    // OTROS
    public static final String PROFILE_OP_COD = "OP";
    public static final Long LONG_1 = 1L;
    public static final int INT_1 = 1;
    public static final int INT_0 = 0;
    public static final String MULTIUSERTYPE = "MU";
    public static final long MAX_AGE_SECS = 3600;

    // IDS FOR SEARCHES
    public static final String COUNTRIES_SEARCHES = "COUNTRIES";

    //STRING FOR PASSWORDS
    public static final String FIRTS_NUMBERS = "012345678";
    public static final String FIRTS_NUMBERS1 = "123456789";
    public static final String ZEROS = "00000000";
    public static final String ABC = "abcdefgh";

    //I18N MESSAGES
    public static final String VALUE_NOT_FOUND = "Value for kay not found.";
}
