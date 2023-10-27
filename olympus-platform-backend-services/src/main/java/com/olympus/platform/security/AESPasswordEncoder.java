package com.olympus.platform.security;

import com.olympus.platform.model.security.SecurityKeyDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;

@Log4j2
public class AESPasswordEncoder implements PasswordEncoder {

    /**
     * Encode the raw password. Generally, a good encoding algorithm applies a SHA-1 or
     * greater hash combined with an 8-byte or greater randomly generated salt.
     *
     * @param rawPassword
     */
    @Override
    public String encode(CharSequence rawPassword) {
        if (rawPassword == null) {
            throw new IllegalArgumentException("rawPassword cannot be null");
        }
        return aesEncryptGenerator(rawPassword.toString());
    }

    /**
     * Verify the encoded password obtained from storage matches the submitted raw
     * password after it too is encoded. Returns true if the passwords match, false if
     * they do not. The stored password itself is never decoded.
     *
     * @param rawPassword     the raw password to encode and match
     * @param encodedPassword the encoded password from storage to compare with
     * @return true if the raw password, after encoding, matches the encoded password from
     * storage
     */
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (rawPassword == null) {
            log.error("rawPassword cannot be null");
            throw new IllegalArgumentException("rawPassword cannot be null");
        }
        if (encodedPassword == null || encodedPassword.length() == 0) {
            log.warn("Empty encoded password");
            return false;
        }
        return true;
    }

    protected String aesEncrypt(String textPass, SecurityKeyDTO securityKeyDTO) {
        log.info(SecurityConstants.PASS_ENCRYPT);
        String hashPassword = null;

        try {
            IvParameterSpec ivParameterSpec =
                    new IvParameterSpec(securityKeyDTO.getIvKey().getBytes(StandardCharsets.UTF_8));
            SecretKeySpec secretKeySpec =
                    new SecretKeySpec(
                            generateKey(securityKeyDTO.getKeyPass(), securityKeyDTO.getSaltKey()).getEncoded(),
                            SecurityConstants.AES_ENCRYPT);
            Cipher cipher = Cipher.getInstance(SecurityConstants.AES_STRING);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
            hashPassword = base64Encode(new String(cipher.doFinal(textPass.getBytes(StandardCharsets.UTF_8))));
        } catch (Exception e) {
            log.error("Ha ocurrido un problema: " + e.getMessage());
        }

        return hashPassword;
    }

    protected String aesEncryptGenerator(String textPass) {
        log.info(SecurityConstants.PASS_ENCRYPT);
        String hashPassword = null;

        try {
            IvParameterSpec ivParameterSpec =
                    new IvParameterSpec(SecurityConstants.SECRET_IV_KEY.getBytes(StandardCharsets.UTF_8));
            SecretKeySpec secretKeySpec =
                    new SecretKeySpec(
                            generateKey(SecurityConstants.SECRET_KEY_PASS, SecurityConstants.SECRET_SALT_KEY).getEncoded(),
                            SecurityConstants.AES_ENCRYPT);
            Cipher cipher = Cipher.getInstance(SecurityConstants.AES_STRING);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
            hashPassword = base64Encode(new String(cipher.doFinal(textPass.getBytes(StandardCharsets.UTF_8))));
        } catch (Exception e) {
            log.error("aesEncryptGenerator" + SecurityConstants.MESSAGE_EXCEPTION + e.getMessage());
        }

        return hashPassword;
    }

    protected SecretKey generateKey(String key, String salt) {
        SecretKeyFactory secretKeyFactory;
        SecretKey secretKeyTemp = null;
        KeySpec keySpec;

        try {
            secretKeyFactory = SecretKeyFactory.getInstance(SecurityConstants.SECRET_KEY_FACTORY);
            keySpec = new PBEKeySpec(key.toCharArray(), salt.getBytes(), 65536, 256);
            secretKeyTemp = secretKeyFactory.generateSecret(keySpec);

        } catch (Exception e) {
            log.error("generateKey" + SecurityConstants.MESSAGE_EXCEPTION + e.getMessage());
        }

        return secretKeyTemp;

    }

    protected static String base64Encode(String text) {
        return Base64.getEncoder().encodeToString(text.getBytes());
    }

}
