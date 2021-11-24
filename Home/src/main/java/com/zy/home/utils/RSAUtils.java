package com.zy.home.utils;

import android.util.Base64;
import android.util.Log;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.home.utils
 * @ClassName: RSAUtils
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/24 18:11
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/24 18:11
 * @UpdateRemark:
 * @Version: 1.0
 */
public class RSAUtils {
    //公钥加密
    public static byte[] encrypt(String content, PublicKey publicKey) {
        try{
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");//java默认"RSA"="RSA/ECB/PKCS1Padding"
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] output = cipher.doFinal(content.getBytes());
            return output;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //公钥加密
    public static byte[] encrypt(byte[] content, PublicKey publicKey) {
        try{
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");//java默认"RSA"="RSA/ECB/PKCS1Padding"
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            return  cipher.doFinal(content);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //私钥解密
    public static byte[] decrypt(byte[] content, PrivateKey privateKey) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            return cipher.doFinal(content);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    //私钥解密
    public static String decrypt(String content, PrivateKey privateKey) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte [] b = cipher.doFinal(content.getBytes());
//            BASE64Encoder encoder = new BASE64Encoder();
            return new String(b);//encoder.encode(b);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * String转公钥PublicKey
     * @param key
     * @return
     * @throws Exception
     */
    public static PublicKey getPublicKey(String key) throws Exception {
        Log.d("123","key -> "+key);
//        byte[] keyBytes;
//        keyBytes = (new BASE64Decoder()).decodeBuffer(key);
//        String encode = Base64Utils.encode(key.getBytes());
        byte[] encode = Base64.encode(key.getBytes(), Base64.DEFAULT);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(encode);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }


    /**
     * String转私钥PrivateKey
     * @param key
     * @return
     * @throws Exception
     */
    public static PrivateKey getPrivateKey(String key) throws Exception {
//        byte[] keyBytes;
//        keyBytes = (new BASE64Decoder()).decodeBuffer(key);
        byte[] bytes = Base64.encode(key.getBytes(),Base64.DEFAULT);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(bytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }

    public static KeyPair generateRSAKeyPair(int keyLength) {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(keyLength);
            return kpg.genKeyPair();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
