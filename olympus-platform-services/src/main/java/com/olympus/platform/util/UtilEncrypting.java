package com.olympus.platform.util;

import com.olympus.platform.model.SecurityKeyDTO;
import java.io.Serializable;
import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class UtilEncrypting implements Serializable {

  public UtilEncrypting() {}

  private static final long serialVersionUID = -9055041322255822886L;

  public String aesEncript(String cadena, SecurityKeyDTO securityKeyDTO) {
    log.info(Constants.PASS_ENCRYPT);
    String hashPassword = null;

    try {
      IvParameterSpec ivParameterSpec =
          new IvParameterSpec(securityKeyDTO.getIvKey().getBytes(Constants.UTF_8));
      SecretKeySpec secretKeySpec =
          new SecretKeySpec(
              generateKey(securityKeyDTO.getIvKey(), securityKeyDTO.getSaltKey()).getEncoded(),
              Constants.AES_ENCRIPT);
      Cipher cipher = Cipher.getInstance(Constants.AES_STRING);
      cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
      // hashPassword = new String(cipher.doFinal(cadena.getBytes(Constantes.UTF_8)));
      hashPassword = base64Encode(new String(cipher.doFinal(cadena.getBytes(Constants.UTF_8))));
    } catch (Exception e) {
      log.error("Ha ocurrido un problema: " + e.getMessage());
    }

    return hashPassword;
  }

  protected SecretKey generateKey(String key, String salt) {
    SecretKeyFactory secretKeyFactory;
    KeySpec keySpec;
    SecretKey secretKeyTemp = null;

    try {
      secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
      keySpec = new PBEKeySpec(key.toCharArray(), salt.getBytes(), 65536, 256);
      secretKeyTemp = secretKeyFactory.generateSecret(keySpec);
    } catch (Exception e) {
      log.error("Ha ocurrido un problema: " + e.getMessage());
    }

    return secretKeyTemp;
  }

  public static String base64Encode(String cadena) {
    return Base64.getEncoder().encodeToString(cadena.getBytes());
  }

  public static String base64Decode(String cadena) {
    return new String(Base64.getDecoder().decode(cadena));
  }
}
