package com.msa.encoder;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * Created by xiongwei on 2018/4/27.
 */
public class MD5PasswordEncoder {
    private static String HASHALGORITHMNAME = "MD5";

    public static String encode(String pwd) {
        return encode(pwd, null);
    }

    public static String encode(String pwd, String salt) {
        //对前端的加密密码进行还原
        String orignPwd = AESEncoder.decodePassword(pwd);
        if (salt != null) {
            ByteSource credentialsSalt = ByteSource.Util.bytes(salt);
            Object obj = new SimpleHash(HASHALGORITHMNAME, orignPwd, credentialsSalt);
            return obj.toString();
        } else {
            Object obj = new SimpleHash(HASHALGORITHMNAME, orignPwd);
            return obj.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(MD5PasswordEncoder.encode("123456", null));
    }
}
