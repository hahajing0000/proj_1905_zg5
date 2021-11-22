package com.zy.mvvm.ui.element;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;

import com.zy.mvvm.R;

public class OneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);


        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    startActivity(new Intent(OneActivity.this,TwoActivity.class),
                            ActivityOptions.makeSceneTransitionAnimation(OneActivity.this, Pair.create(findViewById(R.id.iv_test_1),"image")).toBundle()
                    );
                }
            }
        },3000);
    }

    private Handler mHandler=new Handler();
}