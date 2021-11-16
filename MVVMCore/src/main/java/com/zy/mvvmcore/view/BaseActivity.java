package com.zy.mvvmcore.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.zy.utils.MsgUtils;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.mvvmcore.view
 * @ClassName: BaseActivity
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/12 11:05
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/12 11:05
 * @UpdateRemark:
 * @Version: 1.0
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fullScreen();

        initEnv();
    }

    protected abstract void initEnv();

    /**
     * 跳转到指定Activity
     * @param 
     * @return 
     * @author zhangyue
     * @time 2021/11/12 11:07
     */ 
    protected void jumpToActivity(Class<?> target){
        this.startActivity(new Intent(this,target));
    }
    
    /**
     * 携带参数跳转
     * @param 
     * @return 
     * @author zhangyue
     * @time 2021/11/12 11:09
     */ 
    protected void jumpToActivity(Class<?> target,Bundle bundle){
        Intent intent=new Intent(this,target);
        intent.putExtra("params",bundle);
        this.startActivity(intent);
    }
    
    /**
     * Toast
     * @param
     * @return 
     * @author zhangyue
     * @time 2021/11/12 11:10
     */ 
    protected void showMsg(String msg){
        MsgUtils.getInstance().showMsg(msg);
    }
    
    /**
     * 从资源中获取字符串 全球化处理
     * @param
     * @return 
     * @author zhangyue
     * @time 2021/11/16 13:28
     */ 
    protected String getStringFromRes(int stringId){
        return getResources().getString(stringId);
    }

    /**
     * 全屏处理
     * @param
     * @return
     * @author zhangyue
     * @time 2021/11/16 18:01
     */
    private void fullScreen() {
        //set no title bar 需要在setContentView之前调用
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //如果上面的不起作用，可以换成下面的。
        if (getSupportActionBar()!=null)
        {
            getSupportActionBar().hide();
        }
        if (getActionBar()!=null){
            getActionBar().hide();
        }
        //no status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
