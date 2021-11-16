package com.zy.usercenter;

import com.normal.common.MyApplication;
import com.zy.utils.log.LogStrategy;
import com.zy.utils.log.LogType;
import com.zy.utils.log.LogUtils;
import com.zy.utils.log.Logger;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.usercenter
 * @ClassName: UserCenterApplication
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/12 13:15
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/12 13:15
 * @UpdateRemark:
 * @Version: 1.0
 */
public class UserCenterApplication extends MyApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        Logger logger = new Logger.Builder()
                .setLogStrategy(LogStrategy.Logcat)
                .setDebug(BuildConfig.DEBUG)
                .setMinLogType(LogType.Debug)
                .build();
        LogUtils.getInstance().init(logger);
    }
}
