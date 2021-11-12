package com.zy.mvvmcore.viewmodel;

import com.zy.mvvmcore.repository.BaseRepository;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.mvvmcore.viewmodel
 * @ClassName: BaseViewModel
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/12 10:57
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/12 10:57
 * @UpdateRemark:
 * @Version: 1.0
 */
public abstract class BaseViewModel<Repo extends BaseRepository> extends ViewModel implements LifecycleObserver {
    
    protected Repo mRepository;
    protected LifecycleOwner owner;
    
    public BaseViewModel(LifecycleOwner _owner){
        mRepository=createRepository();
        _owner.getLifecycle().addObserver(this);
        this.owner=_owner;
    }

    /**
     * 创建具体的数据仓库
     * @param
     * @return 
     * @author zhangyue
     * @time 2021/11/12 11:03
     */ 
    protected abstract Repo createRepository();


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void activityOnCreate(){
        initRes();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void activityOnStop(){
        releaseRes();
    }

    /**
     * 释放资源
     * @param 
     * @return 
     * @author zhangyue
     * @time 2021/11/12 11:01
     */ 
    protected abstract void releaseRes();

    /**
     * 子类初始化资源
     * @param 
     * @return 
     * @author zhangyue
     * @time 2021/11/12 11:00
     */ 
    protected abstract void initRes();
}
