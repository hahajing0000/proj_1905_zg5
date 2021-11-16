package com.zy.net.common;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import com.zy.common.MyApplication;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.net.common
 * @ClassName: Constanct
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/15 13:44
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/15 13:44
 * @UpdateRemark:
 * @Version: 1.0
 */
public class Constanct {
    /**
     * OkHttp连接读写超时时间
     */
    public static final int TIMEOUT=1;
    
    /**
     * 获取验证码
     * @param
     * @return 
     * @author zhangyue
     * @time 2021/11/15 14:29
     */ 
    public static String getAuthCode(){
        try {
            ApplicationInfo info = MyApplication.getAppContext().getPackageManager().getApplicationInfo(MyApplication.getAppContext().getPackageName(), PackageManager.GET_META_DATA);
            String authCode=info.metaData.getString("authCode");
            return authCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
