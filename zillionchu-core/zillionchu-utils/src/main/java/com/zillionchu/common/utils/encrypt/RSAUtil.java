package com.zillionchu.common.utils.encrypt;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;


public class RSAUtil {

    private static String publicKey; // 公钥
    private static String privateKey; // 私钥

    public static void generateKey() {
        KeyPairGenerator keyPairGenerator;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            SecureRandom sr = new SecureRandom();
            keyPairGenerator.initialize(512, sr);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
            RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
            publicKey = Base64.encodeBase64String(rsaPublicKey.getEncoded());
            privateKey = Base64.encodeBase64String(rsaPrivateKey.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String encryptByprivateKey(String content, String privateKeyStr, int opmode) {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKeyStr));
        KeyFactory keyFactory;
        PrivateKey privateKey;
        Cipher cipher;
        byte[] result;
        String text = null;
        try {
            keyFactory = KeyFactory.getInstance("RSA");
            privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
            cipher = Cipher.getInstance("RSA");
            cipher.init(opmode, privateKey);
            if (opmode == Cipher.ENCRYPT_MODE) {
                result = cipher.doFinal(content.getBytes());
                text = Base64.encodeBase64String(result);
            } else if (opmode == Cipher.DECRYPT_MODE) {
                result = cipher.doFinal(Base64.decodeBase64(content));
                text = new String(result, "UTF-8");
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return text;
    }

    public static String encryptByPublicKey(String content, String publicKeyStr, int opmode) {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKeyStr));
        KeyFactory keyFactory;
        PublicKey publicKey;
        Cipher cipher;
        byte[] result;
        String text = null;
        try {
            keyFactory = KeyFactory.getInstance("RSA");
            publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
            cipher = Cipher.getInstance("RSA");
            cipher.init(opmode, publicKey);
            if (opmode == Cipher.ENCRYPT_MODE) {
                result = cipher.doFinal(content.getBytes());
                text = Base64.encodeBase64String(result);
            } else if (opmode == Cipher.DECRYPT_MODE) {
                result = cipher.doFinal(Base64.decodeBase64(content));
                text = new String(result, "UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }

}