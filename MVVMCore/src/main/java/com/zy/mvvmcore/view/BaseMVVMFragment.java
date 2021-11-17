package com.zy.mvvmcore.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zy.mvvmcore.exception.MVVMNormalException;
import com.zy.mvvmcore.viewmodel.BaseViewModel;

import java.util.HashMap;
import java.util.Map;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.mvvmcore.view
 * @ClassName: BaseMVVMFragment
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/17 15:22
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/17 15:22
 * @UpdateRemark:
 * @Version: 1.0
 */
public abstract class BaseMVVMFragment<VM extends BaseViewModel,Binding extends ViewDataBinding> extends BaseLazyFragment {
    protected VM mViewModel;
    protected Binding mBinding;

    /**
     * 存放UI上所需要的数据源（页面变量）
     * @param
     * @return
     * @author zhangyue
     * @time 2021/11/12 11:25
     */
    private HashMap<Integer,Object> mMap=new HashMap<>();
    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mViewModel= createViewModel();
        mBinding= DataBindingUtil.inflate(inflater,getLayoutId(),null,false);
        mBinding.setLifecycleOwner(this);
        prepareSetVars(mMap);
        setVars(mBinding,mMap);
        return mBinding.getRoot();
    }

    /**
     * 将设置的数据源绑定到DataBinding
     * @param
     * @return
     * @author zhangyue
     * @time 2021/11/12 11:27
     */
    private void setVars(Binding mBinding, HashMap<Integer, Object> mMap) {
        if (mMap==null||mMap.size()==0){
            throw new MVVMNormalException("please set variables...");
        }
        for (Map.Entry<Integer,Object> entry:mMap.entrySet()){
            mBinding.setVariable(entry.getKey(),entry.getValue());
        }
    }

    /**
     * 项目父类Map添加 变量
     * @param
     * @return
     * @author zhangyue
     * @time 2021/11/12 11:26
     */
    protected abstract void prepareSetVars(HashMap<Integer, Object> mMap);

    protected abstract int getLayoutId();

    protected abstract VM createViewModel();
}
