package com.zy.home.repository;

import com.zy.home.entity.RecommendTypeEntity;
import com.zy.home.model.RecommendRemoteModel;
import com.zy.home.service.api.RecommendTypeApi;
import com.zy.mvvmcore.common.InjectModel;
import com.zy.mvvmcore.repository.BaseRepository;
import com.zy.net.RetrofitFactory;
import com.zy.net.protocol.resp.BaseRespEntity;

import java.util.List;

import androidx.lifecycle.LiveData;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.home.repository
 * @ClassName: RecommendRepository
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/22 14:03
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/22 14:03
 * @UpdateRemark:
 * @Version: 1.0
 */
public class RecommendTypeRepository extends BaseRepository {
    @InjectModel
    RecommendRemoteModel remoteModel;


    public LiveData<BaseRespEntity<List<RecommendTypeEntity>>> getDatas(){
        return remoteModel.getDatas();
    }
}
