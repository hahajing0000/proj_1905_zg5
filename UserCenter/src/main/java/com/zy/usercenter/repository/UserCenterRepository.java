package com.zy.usercenter.repository;

import com.zy.mvvmcore.common.InjectModel;
import com.zy.mvvmcore.repository.BaseRepository;
import com.zy.net.protocol.resp.BaseRespEntity;
import com.zy.usercenter.entity.UserEntity;
import com.zy.usercenter.model.UserCenterLocalModel;
import com.zy.usercenter.model.UserCenterRemoteModel;

import androidx.lifecycle.LiveData;
import io.reactivex.schedulers.Schedulers;

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
public class UserCenterRepository extends BaseRepository{

    public UserCenterRepository(){
        super();
    }

    @InjectModel
    UserCenterRemoteModel remoteModel;
    @InjectModel
    UserCenterLocalModel localModel;

    /**
     * 用户登录方法
     * @param
     * @return 
     * @author zhangyue
     * @time 2021/11/12 13:38
     */ 
    public LiveData<BaseRespEntity<UserEntity>> login(String phoneNumber, String pwd){
        if (true){
        //            mModel —— Local
           return localModel.login(phoneNumber,pwd);
        }
        else{
            //mModel —— Remote
            return remoteModel.login(phoneNumber,pwd);
        }
    }
}
