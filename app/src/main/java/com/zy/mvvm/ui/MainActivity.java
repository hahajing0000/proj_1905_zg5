package com.zy.mvvm.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;
import com.zy.classify.view.ClassifyFragment;
import com.zy.discover.view.DiscoverFragment;
import com.zy.home.view.HomeFragment;
import com.zy.mvvm.R;
import com.zy.mvvm.ui.adapter.MainViewPagerAdapter;
import com.zy.mvvmcore.view.BaseActivity;
import com.zy.shopingtrolley.view.ShopingTrolleyFragment;
import com.zy.usercenter.ui.MineFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private BottomNavigationView bnvMain;
    private ViewPager vpMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void initView() {
        super.initView();
        bnvMain = (BottomNavigationView) findViewById(R.id.bnv_main);
        vpMain = (ViewPager) findViewById(R.id.vp_main);
        initViewPager();

        bnvMain.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);
    }

    /**
     * 初始化ViewPager
     * @param
     * @return 
     * @author zhangyue
     * @time 2021/11/17 16:11
     */ 
    private void initViewPager() {
        List<Fragment> list=new ArrayList<>();
        Fragment home=new HomeFragment();
        Fragment classify=new ClassifyFragment();
        Fragment discover=new DiscoverFragment();
        Fragment shopingTrolley=new ShopingTrolleyFragment();
        Fragment mine=new MineFragment();

        list.add(home);
        list.add(classify);
        list.add(discover);
        list.add(shopingTrolley);
        list.add(mine);

        MainViewPagerAdapter adapter=new MainViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_SET_USER_VISIBLE_HINT,list);
        vpMain.setAdapter(adapter);
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        vpMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                doSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        bnvMain.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.menu_home:
                        doSelected(0);
                        break;
                    case R.id.menu_type:
                        doSelected(1);
                        break;
                    case R.id.menu_find:
                        doSelected(2);
                        break;
                    case R.id.menu_troelly:
                        doSelected(3);
                        break;
                    case R.id.menu_mine:
                        doSelected(4);
                        break;
                }
                return false;
            }
        });
    }

    /**
     * 处理选中
     * @param
     * @return
     * @author zhangyue
     * @time 2021/11/17 16:27
     */
    private void doSelected(int index){
        vpMain.setCurrentItem(index);
        bnvMain.getMenu().getItem(index).setChecked(true);
    }

    @Override
    protected void initEnv() {

    }


    @Override
    protected void initData() {
        super.initData();

    }
}