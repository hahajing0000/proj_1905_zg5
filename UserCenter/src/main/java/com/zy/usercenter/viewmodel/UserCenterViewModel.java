package com.zy.usercenter.viewmodel;

import com.zy.mvvmcore.viewmodel.BaseViewModel;
import com.zy.net.protocol.resp.BaseRespEntity;
import com.zy.usercenter.entity.UserEntity;
import com.zy.usercenter.repository.UserCenterRepository;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.usercenter.viewmodel
 * @ClassName: UserCenterViewModel
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/12 13:38
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/12 13:38
 * @UpdateRemark:
 * @Version: 1.0
 */
public class UserCenterViewModel extends BaseViewModel<UserCenterRepository> {
    //页面 数据 源
    public MutableLiveData<UserEntity> source=new MutableLiveData<>();
    public UserCenterViewModel(LifecycleOwner _owner) {
        super(_owner);
    }

    @Override
    protected UserCenterRepository createRepository() {
        return new UserCenterRepository();
    }

    @Override
    protected void releaseRes() {

    }

    @Override
    protected void initRes() {

    }

    public LiveData<BaseRespEntity<UserEntity>> login(String phoneNumber, String pwd){
        return mRepository.login(phoneNumber, pwd);
    }
}
