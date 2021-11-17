package com.zy.mvvm.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;
import com.zy.mvvm.R;
import com.zy.mvvmcore.view.BaseActivity;

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

        bnvMain.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        bnvMain.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.menu_home:

                        break;
                    case R.id.menu_type:

                        break;
                    case R.id.menu_find:

                        break;
                    case R.id.menu_troelly:

                        break;
                    case R.id.menu_mine:

                        break;
                }
                return false;
            }
        });
    }

    @Override
    protected void initEnv() {

    }


}