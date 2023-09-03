package com.example.demo.common.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.Base64Utils;
import org.springframework.util.DigestUtils;

import java.nio.charset.Charset;
import java.util.List;

public class CertNoSecureHelper {
    private static final Logger logger = LogManager.getLogger(CertNoSecureHelper.class);
    private static final Charset UTF8 = Charset.forName("UTF-8");

    private byte[][] keyBytesGroup1;
    private byte[][] keyBytesGroup2;

    public CertNoSecureHelper(List<String> keyGroup1, List<String> keyGroup2) throws Exception {
        if (null == keyGroup1 || keyGroup1.isEmpty()) {
            throw new IllegalArgumentException("第1个list构造参数不能为空");
        } else if (keyGroup1.size() != 11) {
            throw new IllegalArgumentException("第1个list构造参数的元素个数必须是11个");
        }

        if (null == keyGroup2 || keyGroup2.isEmpty()) {
            throw new IllegalArgumentException("第2个list构造参数不能为空");
        } else if (keyGroup1.size() != 11) {
            throw new IllegalArgumentException("第2个list构造参数的元素个数必须是11个");
        }

        keyBytesGroup1 = new byte[11][16];
        for (int i = 0; i < keyGroup1.size(); i++) {
            String base64 = keyGroup1.get(i);
            byte[] bytes;
            try {
                bytes = Base64Utils.decodeFromUrlSafeString(base64.trim());
            } catch (Throwable e) {
//                throw new Exception("无效的CertNoSecureHelper构造参数值\"" + base64 + "\"，必须是UrlSafe Base64串", e);
                throw new Exception(e);
            }
            if (16 != bytes.length) {
//                throw new BootstrapException(
//                        "无效的CertNoSecureHelper构造参数值\"" + base64 + "\"，必须是16个字节byte对应的UrlSafe Base64串");
            }
            keyBytesGroup1[i] = bytes;
        }

        keyBytesGroup2 = new byte[11][16];
        for (int i = 0; i < keyGroup2.size(); i++) {
            String base64 = keyGroup2.get(i);
            byte[] bytes;
            try {
                bytes = Base64Utils.decodeFromUrlSafeString(base64);
            } catch (Throwable e) {
//                throw new BootstrapException("无效的CertNoSecureHelper构造参数值\"" + base64 + "\"，必须是UrlSafe Base64串", e);
                throw new Exception(e);
            }
            if (16 != bytes.length) {
//                throw new BootstrapException(
//                        "无效的CertNoSecureHelper构造参数值\"" + base64 + "\"，必须是16个字节byte对应的UrlSafe Base64串");
            }
            keyBytesGroup2[i] = bytes;
        }

    }

    /**
     * 证件号码加密
     *
     * @param certNo
     * @return
     * @author <a href="mailto:wengyongyi@crc.com.hk">wengyongyi</a>
     */
    public String encrypt(String certNo) {
        if (null == certNo || (certNo = certNo.trim()).length() <= 2) {
            return certNo;
        }
        char firstChar = certNo.charAt(0);
        char lastChar = certNo.charAt(certNo.length() - 1);
        byte[] aesKeyBytes = findKeyBytes(firstChar, lastChar);
        try {
            byte[] resultBytes = AesUtils.encryptBytes(certNo.getBytes(UTF8), aesKeyBytes);
            return Base64Utils.encodeToUrlSafeString(resultBytes);
        } catch (Exception e) {
            logger.warn("对证件号{}加密失败", certNo, e);
//            throw e;
        }
        return "";
    }

    /**
     * 证件号码解密
     *
     * @param encryptedCertNo
     *            被AES加密后的证件号码密文, 对应数据库中的aes_cert_no
     * @param maskCertNo
     *            掩码后的证件号码
     * @return
     * @author <a href="mailto:wengyongyi@crc.com.hk">wengyongyi</a>
     */
    public String decrypt(String encryptedCertNo, String maskCertNo) {
        if (null == maskCertNo || maskCertNo.length() <= 2) {
            return encryptedCertNo;
        }
        byte[] aesKeyBytes = findKeyBytes(maskCertNo.charAt(0), maskCertNo.charAt(maskCertNo.length() - 1));
        byte[] encryptedBytes = Base64Utils.decodeFromUrlSafeString(encryptedCertNo);

        try {
            byte[] resultBytes = AesUtils.decryptBytes(encryptedBytes, aesKeyBytes);
            return new String(resultBytes, UTF8);
        } catch (Exception e) {
            logger.warn("对证件号解密失败，请检查DB中的数据是否被破坏, aesCertNo: {}, maskCertNo: {}", encryptedCertNo, maskCertNo, e);
//            throw new FinException(FinCommonReturnCode.ERR_DB_BAD_CERT_NO);
//            throw new Exception(e);
        }
        return "";
    }

    /**
     * 计算证件号码的MD5散列值，计算结果固定为32个字符。
     *
     * @param certNo
     * @return
     * @author <a href="mailto:wengyongyi@crc.com.hk">wengyongyi</a>
     */
    public String toHashString(String certNo) {
        if (null == certNo || certNo.length() <= 2) {
            return certNo;
        }
        char firstChar = certNo.charAt(0);
        char lastChar = certNo.charAt(certNo.length() - 1);

        byte[] contentBytes = certNo.getBytes(UTF8);
        byte[] saltBytes = findKeyBytes(firstChar, lastChar);

        byte[] saltedContentBytes = new byte[contentBytes.length + saltBytes.length];
        System.arraycopy(contentBytes, 0, saltedContentBytes, 0, contentBytes.length);
        System.arraycopy(saltBytes, 0, saltedContentBytes, contentBytes.length, saltBytes.length);

        return DigestUtils.md5DigestAsHex(saltedContentBytes);
    }

    /**
     * 掩码处理，只保留前3位和后4位，其他替换为星号。
     *
     * @param certNo
     * @return
     */
    public String toMaskString(String certNo) {
        if (null == certNo || certNo.length() <= 7) {
            return certNo;
        }

        StringBuilder s = new StringBuilder();
        s.append(certNo.substring(0, 3));
        for (int i = 0, maskLen = certNo.length() - 7; i < maskLen; i++) {
            s.append('*');
        }
        s.append(certNo.substring(certNo.length() - 4));
        return s.toString();
    }

    private byte[] findKeyBytes(char firstChar, char lastChar) {
        byte[] aesKeyBytes1;
        if (firstChar >= '0' && firstChar <= '9') {
            aesKeyBytes1 = keyBytesGroup1[firstChar - 48];
        } else {
            aesKeyBytes1 = keyBytesGroup1[10];
        }

        byte[] aesKeyBytes2;
        if (lastChar >= '0' && lastChar <= '9') {
            aesKeyBytes2 = keyBytesGroup2[lastChar - 48];
        } else {
            aesKeyBytes2 = keyBytesGroup2[10];
        }

        byte[] aesKeyBytes = new byte[aesKeyBytes1.length + aesKeyBytes2.length];
        System.arraycopy(aesKeyBytes1, 0, aesKeyBytes, 0, aesKeyBytes1.length);
        System.arraycopy(aesKeyBytes2, 0, aesKeyBytes, aesKeyBytes1.length, aesKeyBytes2.length);
        return aesKeyBytes;
    }


    public static void main(String[] args) {

        String certNo = "610525199401182216";

//        CertNoSecureHelper certNoSecureHelper = new CertNoSecureHelper();
    }
}
