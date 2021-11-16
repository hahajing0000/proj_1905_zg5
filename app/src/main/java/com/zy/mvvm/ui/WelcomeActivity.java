package com.zy.mvvm.ui;

import android.os.Bundle;
import android.widget.TextView;

import com.zy.common.utils.AppUtils;
import com.zy.mvvm.R;
import com.zy.mvvm.wiget.ProgressView;
import com.zy.mvvmcore.view.BaseActivity;

public class WelcomeActivity extends BaseActivity {
    private ProgressView pvWelcome;
    private TextView tvWelcomeAppversion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        pvWelcome = (ProgressView) findViewById(R.id.pv_welcome);
        tvWelcomeAppversion = (TextView) findViewById(R.id.tv_welcome_appversion);
        tvWelcomeAppversion.setText("Version:"+AppUtils.getVerName(this));
        pvWelcome.setListener(new ProgressView.ProgressViewListener() {
            @Override
            public void finish() {
                jumpToActivity(MainActivity.class);
                overridePendingTransition(R.anim.left_in,R.anim.left_out);
                WelcomeActivity.this.finish();
            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    protected void initEnv() {

    }
}