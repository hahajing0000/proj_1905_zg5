package com.zy.usercenter.model;

import com.zy.mvvmcore.model.IModel;
import com.zy.net.RetrofitFactory;
import com.zy.net.protocol.resp.BaseRespEntity;
import com.zy.usercenter.entity.UserEntity;
import com.zy.usercenter.model.service.api.UserCenterApi;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.usercenter.model.service
 * @ClassName: UserCenterLocalModel
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/16 13:32
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/16 13:32
 * @UpdateRemark:
 * @Version: 1.0
 */
public class UserCenterLocalModel implements IModel {
    /**
     * 登录方法
     * @param
     * @return
     * @author zhangyue
     * @time 2021/11/12 13:36
     */
    public LiveData<BaseRespEntity<UserEntity>> login(String phoneNumber, String pwd){
        //使用Room访问本地Sqlite数据库 来完成没网时的业务操作

        MutableLiveData<BaseRespEntity<UserEntity>> tempData=new MutableLiveData<>();
        tempData.setValue(new BaseRespEntity<UserEntity>());
        return tempData;
    }
}
