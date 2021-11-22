package com.zy.home.model;

import com.zy.home.entity.RecommendTypeEntity;
import com.zy.home.service.api.RecommendTypeApi;
import com.zy.mvvmcore.model.IModel;
import com.zy.net.RetrofitFactory;
import com.zy.net.protocol.resp.BaseRespEntity;

import java.util.List;

import androidx.lifecycle.LiveData;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.home.model
 * @ClassName: RecommendRemoteModel
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/22 14:00
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/22 14:00
 * @UpdateRemark:
 * @Version: 1.0
 */
public class RecommendRemoteModel implements IModel {
    public LiveData<BaseRespEntity<List<RecommendTypeEntity>>> getDatas(){
        RecommendTypeApi api = RetrofitFactory.getInstance().create(RecommendTypeApi.class);
        return api.getTypes();
    }
}
