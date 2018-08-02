package com.msa.encoder;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by xiongwei on 2018/4/24.
 */
public class AESEncoder {
    private final static String charset = "UTF-8";
    private final static String ivParam = "0102020303040506";
    private final static String sKey = "leemenzzleemenzz";
    private final static String sType = "AES";
    private static String str = "AES/CBC/PKCS5Padding";

    // 加密
    public static String Encrypt(String sSrc, String sKey) throws Exception {

        vaildKey(sKey);

        byte[] raw = sKey.getBytes();
        SecretKeySpec skeySpec = new SecretKeySpec(raw, sType);

        Cipher cipher = Cipher.getInstance(str);//"算法/模式/补码方式"
        IvParameterSpec iv = new IvParameterSpec(ivParam.getBytes(charset));//使用CBC模式，需要一个向量iv，可增加加密算法的强度
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes(charset));
        return new BASE64Encoder().encode(encrypted);
    }

    // 解密
    public static String Decrypt(String sSrc, String sKey) throws Exception {
        vaildKey(sKey);
        byte[] raw = sKey.getBytes("ASCII");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, sType);
        Cipher cipher = Cipher.getInstance(str);
        IvParameterSpec iv = new IvParameterSpec(ivParam.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
        byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);//先用bAES64解密
        byte[] original = cipher.doFinal(encrypted1);
        String originalString = new String(original, charset);
        return originalString;
    }

    private static void vaildKey(String sKey) {
        if (sKey == null) {
            throw new RuntimeException("Key为空null");
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            throw new RuntimeException("Key长度不是16位");
        }
    }

    public static String decodePassword(String rawPass) {
        try {
            return Decrypt(rawPass, sKey);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
        return false;
    }
}
