package com.zy.home.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;

import com.zy.home.BR;
import com.zy.home.R;
import com.zy.home.databinding.HomeActivityTestBinding;
import com.zy.home.entity.RecommendTypeEntity;
import com.zy.home.service.api.RecommendTypeApi;
import com.zy.home.viewmodel.RecommendTypeViewModel;
import com.zy.mvvmcore.view.BaseMVVMActivity;
import com.zy.net.RetrofitFactory;
import com.zy.net.protocol.resp.BaseRespEntity;

import java.util.HashMap;
import java.util.List;

public class TestActivity extends BaseMVVMActivity<RecommendTypeViewModel, HomeActivityTestBinding> {

    @Override
    protected void initEnv() {

    }

    @Override
    protected void prepareSetVars(HashMap<Integer, Object> mMap) {
        mMap.put(BR.vm,mViewModel);
    }

    @Override
    protected RecommendTypeViewModel createViewModel() {
        return new RecommendTypeViewModel(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.home_activity_test;
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewModel.getDatas();


    }
}