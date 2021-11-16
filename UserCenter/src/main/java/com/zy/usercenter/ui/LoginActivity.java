package com.zy.usercenter.ui;

import android.util.Log;
import android.view.View;

import com.zy.mvvmcore.view.BaseMVVMActivity;
import com.zy.net.RetrofitFactory;
import com.zy.net.protocol.resp.BaseRespEntity;
import com.zy.usercenter.BR;
import com.zy.usercenter.R;
import com.zy.usercenter.databinding.ActivityLoginBinding;
import com.zy.usercenter.entity.TestUserEntity;
import com.zy.usercenter.entity.UserEntity;
import com.zy.usercenter.model.service.api.LoginApi;
import com.zy.usercenter.viewmodel.UserCenterViewModel;
import com.zy.utils.MsgUtils;
import com.zy.utils.log.LogStrategy;
import com.zy.utils.log.LogType;
import com.zy.utils.log.LogUtils;
import com.zy.utils.log.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

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

//        List<String> list=new ArrayList<>();
//        Class<? extends List> aClass = list.getClass();
//        Method[] declaredMethods = aClass.getDeclaredMethods();
//        for (int i=0;i<declaredMethods.length;i++){
//            if(declaredMethods[i].getName().equals("add")){
//                Class<?> returnType = declaredMethods[i].getReturnType();
//                String name = returnType.getName();
//                if (name.equals("void")){
//                    try {
//                        declaredMethods[i].setAccessible(true);
//                        declaredMethods[i].invoke(list,0,1);
//                        declaredMethods[i].invoke(list,1,1.0f);
//                        declaredMethods[i].invoke(list,2,new UserEntity());
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//
//            }
//        }
//
//        for (Object obj:list){
//
//            Log.d("123", "onLogin: "+obj);
//        }

        LoginApi o = RetrofitFactory.getInstance().create(LoginApi.class);
        TestUserEntity testUserEntity=new TestUserEntity();
        testUserEntity.setUsername("1");
        testUserEntity.setPwd("111");
        LiveData<BaseRespEntity<TestUserEntity>> login = o.login(testUserEntity);
        login.observe(this, new Observer<BaseRespEntity<TestUserEntity>>() {
            @Override
            public void onChanged(BaseRespEntity<TestUserEntity> entity) {
                LogUtils.getInstance().writeLog(LogType.Debug,entity.toString());
            }
        });


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