package com.jingdianjichi.subject.infa.basic.utils;

import com.alibaba.druid.filter.config.ConfigTools;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * @author 坤
 * @description 数据库加密
 * @date 2024/3/28 22:17
 */

public class DruidEncryptUtils {

    private static String publicKey;
    private static String privateKey;

    static {
        try {
            String[] keyPair = ConfigTools.genKeyPair(512);
            privateKey = keyPair[0];
            publicKey = keyPair[1];
            System.out.println("privateKey:"+privateKey);
            System.out.println("publicKey:"+publicKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //加密
    public static String encrypt(String plainText) {
        String encrypt = null;
        try {
            encrypt = ConfigTools.encrypt(privateKey, plainText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encrypt;
    }

    public static String decrypt(String encryptText) {
        String decrypt = null;
        try {
            decrypt = ConfigTools.decrypt(publicKey,encryptText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decrypt;
    }

    public static void main(String[] args) {
        String encrypt = encrypt("137080");
        System.out.println("encrypt:"+encrypt);
        String decrypt = decrypt(encrypt);
        System.out.println("decrypt:"+decrypt);
    }
}
