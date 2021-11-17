package com.zy.mvvm.ui.adapter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.mvvm.ui.adapter
 * @ClassName: MainViewPagerAdapter
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/17 8:20
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/17 8:20
 * @UpdateRemark:
 * @Version: 1.0
 */
public class MainViewPagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragmentList=null;
    public MainViewPagerAdapter(@NonNull FragmentManager fm, int behavior, List<Fragment> fragmentList) {
        super(fm, behavior);
        this.fragmentList=fragmentList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return this.fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
