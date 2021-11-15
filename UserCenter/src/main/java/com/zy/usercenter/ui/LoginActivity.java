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
import com.zy.utils.log.LogStrategy;
import com.zy.utils.log.LogType;
import com.zy.utils.log.LogUtils;
import com.zy.utils.log.Logger;

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



        LogUtils.getInstance().writeLog(LogType.Warnning,"11111111");

        String phoneNumber=mViewModel.source.getValue().getPhoneNumber();
        String pwd=mViewModel.source.getValue().getPwd();
        Log.d("123", String.format("phoneNumber : %s Pwd : %s",phoneNumber,pwd));
        mViewModel.login(phoneNumber,pwd).observe(this, new Observer<UserEntity>() {
            @Override
            public void onChanged(UserEntity entity) {
                showMsg(entity.toString());
            }
        });
    }

    @Override
    protected void initEnv() {
        mViewModel.source.setValue(new UserEntity());
    }
}