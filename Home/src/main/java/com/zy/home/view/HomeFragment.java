package com.zy.home.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zy.home.R;
import com.zy.mvvmcore.view.BaseLazyFragment;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.home.view
 * @ClassName: HomeFragment
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/17 15:52
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/17 15:52
 * @UpdateRemark:
 * @Version: 1.0
 */
public class HomeFragment extends BaseLazyFragment {
    @Override
    protected void lazyLoadData() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        initView(view);
        return view;
    }

    private void initView(View view) {

    }
}
