package com.zy.usercenter.model.service.api;

import com.zy.net.protocol.resp.BaseRespEntity;
import com.zy.usercenter.entity.TestUserEntity;

import androidx.lifecycle.LiveData;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.usercenter.model.service.api
 * @ClassName: LoginApi
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/15 14:38
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/15 14:38
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface LoginApi {
    @POST("api/User/login")
    LiveData<BaseRespEntity<TestUserEntity>> login(@Body TestUserEntity entity);
}
