package com.zy.home.utils;

import android.text.TextUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import androidx.annotation.NonNull;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.home.utils
 * @ClassName: MD5Utils
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/25 8:05
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/25 8:05
 * @UpdateRemark:
 * @Version: 1.0
 */
public class MD5Utils {
    @NonNull
    public static String md5(String string) {
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(string.getBytes());
            StringBuilder result = new StringBuilder();
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result.append(temp);
            }
            return result.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}