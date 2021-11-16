package com.zy.usercenter.ui;

import android.util.Log;
import android.view.View;

import com.zy.mvvmcore.view.BaseMVVMActivity;
import com.zy.net.protocol.resp.BaseRespEntity;
import com.zy.usercenter.BR;
import com.zy.usercenter.R;
import com.zy.usercenter.databinding.ActivityLoginBinding;
import com.zy.usercenter.entity.UserEntity;
import com.zy.usercenter.viewmodel.UserCenterViewModel;
import com.zy.utils.log.LogType;
import com.zy.utils.log.LogUtils;

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
        String phoneNumber=mViewModel.source.getValue().getUsername();
        String pwd=mViewModel.source.getValue().getPwd();
        Log.d("123", String.format("phoneNumber : %s Pwd : %s",phoneNumber,pwd));
        mViewModel.login(phoneNumber,pwd).observe(this, new Observer<BaseRespEntity<UserEntity>>() {
            @Override
            public void onChanged(BaseRespEntity<UserEntity> userEntityBaseRespEntity) {
                if (userEntityBaseRespEntity.getCode()==200){
                    jumpToActivity(MainActivity.class);
                }else {

                    showMsg(getStringFromRes(R.string.login_login_usernotexists));
                }
            }
        });
    }

    @Override
    protected void initEnv() {
        mViewModel.source.setValue(new UserEntity());
    }
}