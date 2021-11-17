package com.zy.mvvmcore.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.mvvmcore.view
 * @ClassName: BaseFragment
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/17 14:21
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/17 14:21
 * @UpdateRemark:
 * @Version: 1.0
 */
public abstract class BaseFragment extends Fragment {
    protected BaseActivity mActivity;
    boolean isViewCreated=false;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mActivity= (BaseActivity) getActivity();

        return createView(inflater,container,savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewCreated=true;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
        prepareLoadData();
    }

    boolean isFirst=true;
    private void prepareLoadData() {
        if (isFirst&&isViewCreated){
            loadData();
            isFirst=false;
        }

    }

    protected abstract void loadData();

    protected abstract View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);
}
