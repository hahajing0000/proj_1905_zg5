package com.zy.home;

import com.normal.common.MyApplication;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.sdk.QbSdk;

import java.util.HashMap;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.home
 * @ClassName: HomeApplication
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/22 13:55
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/22 13:55
 * @UpdateRemark:
 * @Version: 1.0
 */
class HomeApplication extends MyApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        //腾讯浏览服务初始化
        HashMap map = new HashMap();
        map.put(TbsCoreSettings.TBS_SETTINGS_USE_SPEEDY_CLASSLOADER, true);
        map.put(TbsCoreSettings.TBS_SETTINGS_USE_DEXLOADER_SERVICE, true);
        QbSdk.initTbsSettings(map);
    }
}
