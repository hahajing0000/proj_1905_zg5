package com.zy.shopingtrolley.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zy.mvvmcore.view.BaseLazyFragment;
import com.zy.shopingtrolley.R;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.shopingtrolley.view
 * @ClassName: ShopingTrolleyFragment
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/17 16:00
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/17 16:00
 * @UpdateRemark:
 * @Version: 1.0
 */
public class ShopingTrolleyFragment extends BaseLazyFragment {
    @Override
    protected void lazyLoadData() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shopingtrolley, null);
        initView(view);
        return view;
    }

    private void initView(View view) {

    }
}
