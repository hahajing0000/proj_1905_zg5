package com.zy.home.service.api;

import com.zy.home.entity.RecommendTypeEntity;
import com.zy.net.protocol.resp.BaseRespEntity;

import java.util.List;

import androidx.lifecycle.LiveData;
import retrofit2.http.GET;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.home.service.api
 * @ClassName: RecommendTypeApi
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/22 13:51
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/22 13:51
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface RecommendTypeApi {
    @GET("api/GoodsType/getRecommendTypes")
    LiveData<BaseRespEntity<List<RecommendTypeEntity>>> getTypes();
}
