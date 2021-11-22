package com.zy.home.viewmodel;

import com.zy.home.entity.RecommendTypeEntity;
import com.zy.home.repository.RecommendTypeRepository;
import com.zy.mvvmcore.viewmodel.BaseViewModel;
import com.zy.net.protocol.resp.BaseRespEntity;

import java.util.List;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.home.viewmodel
 * @ClassName: RecommendTypeViewModel
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/22 14:04
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/22 14:04
 * @UpdateRemark:
 * @Version: 1.0
 */
public class RecommendTypeViewModel extends BaseViewModel<RecommendTypeRepository> {
    public MutableLiveData<String> dataSource=new MutableLiveData<>();
    public RecommendTypeViewModel(LifecycleOwner _owner) {
        super(_owner);
    }

    @Override
    protected RecommendTypeRepository createRepository() {
        return new RecommendTypeRepository();
    }

    @Override
    protected void releaseRes() {

    }

    @Override
    protected void initRes() {

    }

    public void getDatas(){
         mRepository.getDatas().observe(owner, new Observer<BaseRespEntity<List<RecommendTypeEntity>>>() {
             @Override
             public void onChanged(BaseRespEntity<List<RecommendTypeEntity>> listBaseRespEntity) {
                 if (listBaseRespEntity!=null&&listBaseRespEntity.getCode()==200){
                    dataSource.setValue(""+listBaseRespEntity.getData().size());
                 }
             }
         });
    }
}
