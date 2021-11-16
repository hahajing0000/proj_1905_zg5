package com.zy.net.service.api;

import com.zy.net.protocol.resp.TokenRespEntity;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.net.service.api
 * @ClassName: TokenApi
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/15 14:20
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/15 14:20
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface TokenApi {
    @FormUrlEncoded
    @POST("token")
    Call<TokenRespEntity> getToken(@Field("grant_type") String grant_type, @Field("username") String username, @Field("password") String password);
}
