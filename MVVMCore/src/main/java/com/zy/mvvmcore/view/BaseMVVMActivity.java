package com.zy.mvvmcore.view;

import android.os.Bundle;

import com.zy.mvvmcore.exception.MVVMNormalException;
import com.zy.mvvmcore.viewmodel.BaseViewModel;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.mvvmcore.view
 * @ClassName: BaseMVVMActivity
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/12 11:05
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/12 11:05
 * @UpdateRemark:
 * @Version: 1.0
 */
public abstract class BaseMVVMActivity<VM extends BaseViewModel,Binding extends ViewDataBinding> extends BaseActivity {
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
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        mBinding= DataBindingUtil.setContentView(this,getLayoutId());
        //要设置数据绑定的生命周期拥有者 否则livedata属性 变更无法更新UI内容
        mBinding.setLifecycleOwner(this);
        mViewModel=createViewModel();
        super.onCreate(savedInstanceState);
        prepareSetVars(mMap);
        setVars(mBinding,mMap);
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

    /**
     * 创建ViewModel
     * @param
     * @return 
     * @author zhangyue
     * @time 2021/11/12 11:22
     */ 
    protected abstract VM createViewModel();

    /**
     * 设置布局ID
     * @param 
     * @return 
     * @author zhangyue
     * @time 2021/11/12 11:22
     */ 
    protected abstract int getLayoutId();
}
