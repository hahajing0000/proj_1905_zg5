package com.zy.usercenter.ui;

import android.util.Log;
import android.view.View;

import com.zy.mvvmcore.view.BaseMVVMActivity;
import com.zy.usercenter.BR;
import com.zy.usercenter.R;
import com.zy.usercenter.databinding.ActivityLoginBinding;
import com.zy.usercenter.entity.UserEntity;
import com.zy.usercenter.viewmodel.UserCenterViewModel;
import com.zy.utils.MsgUtils;

import java.util.HashMap;

import androidx.lifecycle.Observer;

public class LoginActivity extends BaseMVVMActivity<UserCenterViewModel, ActivityLoginBinding> {


    @Override
    protected void prepareSetVars(HashMap<Integer, Object> mMap) {
        mMap.put(BR.user,mViewModel.source);
        mMap.put(BR.owner,this);
    }

    @Override
    protected UserCenterViewModel createViewModel() {
        return new UserCenterViewModel(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    public void onLogin(View view){
        String phoneNumber=mViewModel.source.getValue().getPhoneNumber();
        String pwd=mViewModel.source.getValue().getPwd();
        Log.d("123", String.format("phoneNumber : %s Pwd : %s",phoneNumber,pwd));
        mViewModel.login(phoneNumber,pwd).observe(this, new Observer<UserEntity>() {
            @Override
            public void onChanged(UserEntity entity) {
                MsgUtils.getInstance().showMsg(entity.toString());
            }
        });
    }

    @Override
    protected void initEnv() {
        mViewModel.source.setValue(new UserEntity());
    }
}