package com.zillionchu.common.utils.encrypt;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Objects;
import java.util.Random;

/**
 * zillionchu
 */
public class AESUtils {

    private static final Random RANDOM = new Random();

    //初始向量
    public static final String AES_IV = "1234567890123456";

    public static final int AES_KEY_LENGTH = 16;

    //编码方式
    public static final String UTF8 = "UTF-8";

    /**
     * AES加密
     *
     * @param cleartext 明文
     * @return 密文
     */
    public static String AESEncrypt(String cleartext, String key, String iv) {
        try {
            IvParameterSpec zeroIv = new IvParameterSpec(iv.getBytes());
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
            //PKCS5Padding比PKCS7Padding效率高，PKCS7Padding可支持IOS加解密
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, zeroIv);
            byte[] encryptedData = cipher.doFinal(cleartext.getBytes(UTF8));
            return new BASE64Encoder().encode(encryptedData);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * AES加密 屏蔽key 及 iv
     *
     * @param cleartext
     * @return
     */
    public static String encrypt(String cleartext) {
        Objects.requireNonNull(cleartext, "cleartext could not be null");
        String key = AESUtils.generateRandom(AESUtils.AES_KEY_LENGTH, true, true);
        return key + AESEncrypt(cleartext, key, AESUtils.AES_IV);
    }

    /**
     * AES解密
     *
     * @param encrypted 密文
     * @return 明文
     */
    public static String AESDecrypt(String encrypted, String key, String iv) {
        try {
            IvParameterSpec zeroIv = new IvParameterSpec(AES_IV.getBytes());
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, zeroIv);
            byte[] decryptedData = cipher.doFinal(new BASE64Decoder().decodeBuffer(encrypted));
            return new String(decryptedData, UTF8);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


    /**
     * AES 解密 屏蔽 key
     *
     * @param encrypted
     * @return
     */
    public static String decrypt(String encrypted) {
        Objects.requireNonNull(encrypted, "encrypted could not be null");

        String k = encrypted.substring(0, AESUtils.AES_KEY_LENGTH);
        String encryptJson = encrypted.substring(AESUtils.AES_KEY_LENGTH);
        return AESDecrypt(encryptJson, k, AESUtils.AES_IV);
    }

    public static String generateRandom(int count, boolean letters, boolean numbers) {
        int start = 0;
        int end = 0;
        char[] chars = null;
        if (count == 0) {
            return "";
        } else if (count < 0) {
            throw new IllegalArgumentException("Requested random string length " + count + " is less than 0.");
        }
        if ((start == 0) && (end == 0)) {
            end = 'z' + 1;
            start = ' ';
            if (!letters && !numbers) {
                start = 0;
                end = Integer.MAX_VALUE;
            }
        }

        char[] buffer = new char[count];
        int gap = end - start;

        while (count-- != 0) {
            char ch;
            if (chars == null) {
                ch = (char) (RANDOM.nextInt(gap) + start);
            } else {
                ch = chars[RANDOM.nextInt(gap) + start];
            }
            if ((letters && Character.isLetter(ch))
                    || (numbers && Character.isDigit(ch))
                    || (!letters && !numbers)) {
                if (ch >= 56320 && ch <= 57343) {
                    if (count == 0) {
                        count++;
                    } else {
                        // low surrogate, insert high surrogate after putting it in
                        buffer[count] = ch;
                        count--;
                        buffer[count] = (char) (55296 + RANDOM.nextInt(128));
                    }
                } else if (ch >= 55296 && ch <= 56191) {
                    if (count == 0) {
                        count++;
                    } else {
                        // high surrogate, insert low surrogate before putting it in
                        buffer[count] = (char) (56320 + RANDOM.nextInt(128));
                        count--;
                        buffer[count] = ch;
                    }
                } else if (ch >= 56192 && ch <= 56319) {
                    // private high surrogate, no effing clue, so skip it
                    count++;
                } else {
                    buffer[count] = ch;
                }
            } else {
                count++;
            }
        }
        return new String(buffer);
    }


    public static void main(String[] args) {
        //String encrypt = encrypt("123456abcdf");
        String encrypt = encrypt("123456abcdf");
        System.out.println(String.format("do encrypt is -- %s", encrypt));
        String decrypt = decrypt(encrypt);
        System.out.println(String.format("do decrypt is -- %s", decrypt));
    }

}
