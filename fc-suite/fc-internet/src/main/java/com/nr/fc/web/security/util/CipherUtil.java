package com.nr.fc.web.security.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * Encrypt and Decrypt Utility class.
 *
 * @author Ruckman Colins S.
 *
 */
public class CipherUtil {

    /* Specify the algorithm. */
    private static final String AES_ECB_PKCS5_PADDING = "AES/ECB/PKCS5Padding";

    /* Specify the private key. */
    private static byte[] key = {0x74, 0x68, 0x69, 0x73, 0x49, 0x73, 0x41, 0x53, 0x65, 0x63, 0x72, 0x65, 0x74, 0x4b,
        0x65, 0x79};

    /**
     * This method will encrypt the given string and return.
     *
     * @param strToEncrypt string to encrypt
     * @return encrypted string.
     */
    public static String encrypt(final String strToEncrypt) {

        try {

            Cipher cipher = Cipher.getInstance(AES_ECB_PKCS5_PADDING);
            final SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            final String encryptedString = Base64.encodeBase64String(cipher.doFinal(strToEncrypt.getBytes()));
            return encryptedString;
        } catch (Exception e) {

            return null;
        }

    }

    /**
     * This method will decrypt the given encrypted string and return.
     *
     * @param strToDecrypt decrypted string.
     * @return decrypted string.
     */
    public static String decrypt(final String strToDecrypt) {

        try {

            Cipher cipher = Cipher.getInstance(AES_ECB_PKCS5_PADDING);
            final SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            final String decryptedString = new String(cipher.doFinal(Base64.decodeBase64(strToDecrypt)));
            return decryptedString;
        } catch (Exception e) {

            return null;
        }
    }
}
