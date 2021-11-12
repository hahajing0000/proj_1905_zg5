package com.zy.usercenter.model;

import android.os.SystemClock;

import com.zy.mvvmcore.model.IModel;
import com.zy.usercenter.entity.UserEntity;
import com.zy.utils.ThreadUtils;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.usercenter.model
 * @ClassName: UserCenterModel
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/12 13:19
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/12 13:19
 * @UpdateRemark:
 * @Version: 1.0
 */
public class UserCenterModel implements IModel {

    /**
     * 登录方法
     * @param 
     * @return 
     * @author zhangyue
     * @time 2021/11/12 13:36
     */ 
    public MutableLiveData<UserEntity> login(String phoneNumber, String pwd){
        //模拟网络请求
        SystemClock.sleep(500);
        MutableLiveData<UserEntity> result=new MutableLiveData<>();
        UserEntity userEntity=new UserEntity(1,"18000001111","",21,"天津市");
        if (ThreadUtils.isMainThread()){
            result.setValue(userEntity);
        }
        else{
            result.postValue(userEntity);
        }
        return result;
    }
}
