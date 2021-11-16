package com.zy.utils;

import android.widget.Toast;

import com.normal.common.MyApplication;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.utils
 * @ClassName: MsgUtils
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/12 11:10
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/12 11:10
 * @UpdateRemark:
 * @Version: 1.0
 */
public class MsgUtils {
    private static volatile MsgUtils instance=null;
    private MsgUtils(){}
    public static MsgUtils getInstance(){
        if (null==instance){
            synchronized (MsgUtils.class){
                if (null==instance){
                    instance=new MsgUtils();
                }
            }
        }
        return instance;
    }

    /**
     * 提示消息
     * @param 
     * @return 
     * @author zhangyue
     * @time 2021/11/12 11:15
     */ 
    public void showMsg(String msg){
        Toast.makeText(MyApplication.getAppContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
