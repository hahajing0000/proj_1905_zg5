package com.zy.classify.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zy.classify.R;
import com.zy.mvvmcore.view.BaseLazyFragment;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.classify.view
 * @ClassName: ClassifyFragment
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/17 15:56
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/17 15:56
 * @UpdateRemark:
 * @Version: 1.0
 */
public class ClassifyFragment extends BaseLazyFragment {
    @Override
    protected void lazyLoadData() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_classify, null);
        initView(view);
        return view;
    }

    private void initView(View view) {

    }
}
