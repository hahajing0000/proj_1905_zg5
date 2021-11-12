package com.zy.mvvmcore.repository;

import com.zy.mvvmcore.model.IModel;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.mvvmcore.repository
 * @ClassName: BaseRepository
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/12 10:55
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/12 10:55
 * @UpdateRemark:
 * @Version: 1.0
 */
public abstract class BaseRepository<M extends IModel> {
    protected M mModel;
    public BaseRepository(){
        mModel=createModel();
    }

    /**
     * 创建实例化Model
     * @param
     * @return 
     * @author zhangyue
     * @time 2021/11/12 10:57
     */ 
    protected abstract M createModel();
}
