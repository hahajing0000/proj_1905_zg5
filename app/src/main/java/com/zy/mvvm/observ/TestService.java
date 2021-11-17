package com.zy.mvvm.observ;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;

import androidx.annotation.Nullable;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.mvvm.observ
 * @ClassName: TestService
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/17 18:43
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/17 18:43
 * @UpdateRemark:
 * @Version: 1.0
 */
public class TestService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        SystemClock.sleep(1500);
        ObservManager.getInstance().notifyAll(1,2,3);
        return START_STICKY;
    }
}
