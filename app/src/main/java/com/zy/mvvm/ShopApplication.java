package com.zy.mvvm;

import android.content.Context;

import com.normal.common.MyApplication;

import androidx.multidex.MultiDex;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.mvvm
 * @ClassName: ShopApplication
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/12 11:14
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/12 11:14
 * @UpdateRemark:
 * @Version: 1.0
 */
public class ShopApplication extends MyApplication {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
