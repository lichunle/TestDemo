package com.example.demo.common.utils;

import com.google.common.base.Utf8;
import org.springframework.util.Base64Utils;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.security.SecureRandom;

public class AesUtils {

    private static final String ALGORITHM = "AES";

    public static byte[] encryptBytes(byte[] contentBytes, byte[] keyBytes) throws Exception {

        try {
            KeyGenerator kgen = KeyGenerator.getInstance(ALGORITHM);

            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
            sr.setSeed(keyBytes);
            kgen.init(128, sr);

            SecretKey secretKey = kgen.generateKey();
            byte[] encodeFormat = secretKey.getEncoded();

            SecretKeySpec keySpec = new SecretKeySpec(encodeFormat, ALGORITHM);

            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            byte[] result = cipher.doFinal(contentBytes);
            return result;
        } catch (Throwable e) {
            throw new Exception(e);
        }
    }

    public static byte[] decryptBytes(byte[] contentBytes, byte[] keyBytes) throws Exception {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance(ALGORITHM);

            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
            sr.setSeed(keyBytes);
            kgen.init(128, sr);

            SecretKey secretKey = kgen.generateKey();
            byte[] encodeFormat = secretKey.getEncoded();

            SecretKeySpec keySpec = new SecretKeySpec(encodeFormat, ALGORITHM);

            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            byte[] result = cipher.doFinal(contentBytes);
            return result;
        } catch (Throwable e) {
            throw new Exception(e);
        }
    }

    public static void main(String[] args) {

        String certNo = "15529356812";
        String aesKey = "abc";
        try {
            // 加密
            byte[] bytes = AesUtils.encryptBytes(certNo.getBytes(Charset.forName("UTF-8")), aesKey.getBytes());
            String s = Base64Utils.encodeToUrlSafeString(bytes);
            System.out.println("加密后：" + s);

            // 解密
            byte[] contents = Base64Utils.decodeFromUrlSafeString(s);
            byte[] decryptBytes = AesUtils.decryptBytes(contents, aesKey.getBytes());
            String ss = new String(decryptBytes, Charset.forName("UTF-8"));
            System.out.println("解密后：" + ss);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
