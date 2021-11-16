package com.zy.usercenter.model;

import com.zy.mvvmcore.model.IModel;
import com.zy.mvvmcore.repository.BaseRepository;
import com.zy.net.RetrofitFactory;
import com.zy.net.protocol.resp.BaseRespEntity;
import com.zy.usercenter.entity.UserEntity;
import com.zy.usercenter.model.service.api.UserCenterApi;

import androidx.lifecycle.LiveData;


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
public class UserCenterRemoteModel implements IModel {

    /**
     * 登录方法
     * @param 
     * @return 
     * @author zhangyue
     * @time 2021/11/12 13:36
     */ 
    public LiveData<BaseRespEntity<UserEntity>> login(String phoneNumber, String pwd){
        UserCenterApi api = RetrofitFactory.getInstance().create(UserCenterApi.class);
        return   api.login(new UserEntity(1,phoneNumber,pwd,"0",""));
    }
}
