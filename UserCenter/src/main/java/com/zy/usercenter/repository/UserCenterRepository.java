package com.zy.usercenter.repository;

import android.os.SystemClock;

import com.zy.mvvmcore.repository.BaseRepository;
import com.zy.usercenter.entity.UserEntity;
import com.zy.usercenter.model.UserCenterModel;
import com.zy.utils.ThreadUtils;

import androidx.lifecycle.MutableLiveData;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.usercenter.repository
 * @ClassName: UserCenterRepository
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/12 13:37
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/12 13:37
 * @UpdateRemark:
 * @Version: 1.0
 */
public class UserCenterRepository extends BaseRepository<UserCenterModel> {
    @Override
    protected UserCenterModel createModel() {
        return new UserCenterModel();
    }

    /**
     * 用户登录方法
     * @param
     * @return 
     * @author zhangyue
     * @time 2021/11/12 13:38
     */ 
    public MutableLiveData<UserEntity> login(String phoneNumber, String pwd){
       return mModel.login(phoneNumber,pwd);
    }
}
