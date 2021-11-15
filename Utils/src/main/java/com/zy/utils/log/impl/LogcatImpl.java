package com.zy.utils.log.impl;

import android.util.Log;

import com.zy.utils.log.ILog;
import com.zy.utils.log.LogType;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.utils.log.impl
 * @ClassName: LogcatImpl
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/13 10:57
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/13 10:57
 * @UpdateRemark:
 * @Version: 1.0
 */
public class LogcatImpl implements ILog {
    private static String TAG="123";
    @Override
    public void writeLog(LogType type, String log) {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("----->").append(log);
        switch (type){
            case Info:
                Log.i(TAG, stringBuilder.toString());
                break;
            case Debug:
                Log.d(TAG, stringBuilder.toString());
                break;
            case Warnning:
                Log.w(TAG, stringBuilder.toString());
                break;
            case Error:
                Log.e(TAG, stringBuilder.toString());
                break;
            default:
                Log.d(TAG, stringBuilder.toString());
                break;
        }
    }
}
