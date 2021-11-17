package com.zy.usercenter.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zy.mvvmcore.view.BaseLazyFragment;
import com.zy.usercenter.R;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.usercenter.ui
 * @ClassName: MineFragment
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/17 16:01
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/17 16:01
 * @UpdateRemark:
 * @Version: 1.0
 */
public class MineFragment extends BaseLazyFragment {
    @Override
    protected void lazyLoadData() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, null);
        initView(view);
        return view;
    }

    private void initView(View view) {

    }
}
