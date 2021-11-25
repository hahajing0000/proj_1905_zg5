package com.zy.home.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.home.utils
 * @ClassName: SHAUtils
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/25 8:07
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/25 8:07
 * @UpdateRemark:
 * @Version: 1.0
 */
public class SHAUtils {
    public static String sha1(String content){
        MessageDigest md = null;
        String result=null;
        try {
            md = MessageDigest.getInstance("sha-1");
            byte[] datd = md.digest(content.getBytes()) ;
            result = byte2String( datd ) ;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String sha224(String content){
        MessageDigest md = null;
        String result=null;
        try {
            md = MessageDigest.getInstance("sha-224") ;
            byte[] datd = md.digest(content.getBytes()) ;
            result = byte2String( datd ) ;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String sha384(String content){
        MessageDigest md = null;
        String result=null;
        try {
            md = MessageDigest.getInstance("sha-384") ;
            byte[] datd = md.digest(content.getBytes()) ;
            result = byte2String( datd ) ;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String sha512(String content){
        MessageDigest md = null;
        String result=null;
        try {
            md = MessageDigest.getInstance("sha-512") ;
            byte[] datd = md.digest(content.getBytes()) ;
            result = byte2String( datd ) ;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static String byte2String( byte[] data ){
        String result = "" ;
        for ( int i = 0 ; i < data.length ; i++ ){
            int value = data[i] & 0xff ; //按位与
            if ( value < 16 ){
                result += "0" ;  //要在前面加上个0
            }
            result += Integer.toHexString(value); //链接字符串
        }
        //第二种转化方法
//        for (byte b : data) {
//            String temp = Integer.toHexString(b & 0xff);
//            if (temp.length() == 1) {
//                temp = "0" + temp;
//            }
//            s += temp;
//        }

        return result;
    }
}
