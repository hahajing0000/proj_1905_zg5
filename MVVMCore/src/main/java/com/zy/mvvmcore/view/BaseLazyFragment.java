package com.zy.mvvmcore.view;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.mvvmcore.view
 * @ClassName: BaseLazyFragment
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/17 15:11
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/17 15:11
 * @UpdateRemark:
 * @Version: 1.0
 */
public abstract class BaseLazyFragment extends BaseFragment {

    //是否用户可见
    boolean isVisibleToUser=false;

    //第一次加载
    boolean isFirst=true;

    //视图创建完成
    boolean isViewCreated=false;

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewCreated=true;
    }

    @Override
    public void setUserVisibleHint(boolean _isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (_isVisibleToUser){
            preformLoadData();
            isVisibleToUser=_isVisibleToUser;
        }else{
            isVisibleToUser=false;
        }

    }

    /**
     * 预先准备加载数据
     * @param
     * @return 
     * @author zhangyue
     * @time 2021/11/17 15:17
     */ 
    private void preformLoadData() {
        if (isFirst&&isVisibleToUser&&isViewCreated){
            lazyLoadData();
            isFirst=false;
        }
    }

    /**
     * 延时加载数据
     * @param
     * @return 
     * @author zhangyue
     * @time 2021/11/17 15:21
     */ 
    protected abstract void lazyLoadData();
    

}
