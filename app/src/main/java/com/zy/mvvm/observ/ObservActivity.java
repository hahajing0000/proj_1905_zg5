package com.zy.mvvm.observ;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.zy.mvvm.R;

import java.util.Observer;
import java.util.concurrent.TimeUnit;

public class ObservActivity extends AppCompatActivity implements IObserver{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observ);

        ObservManager.getInstance().register(this);
        startService(new Intent(this,TestService.class));

        Observable.just("1").subscribe(new BaseObserver<String>() {
            @Override
            public void onNext(String s) {
                super.onNext(s);
            }
        });

    }

    @Override
    public void notify(Object... datas) {
        Log.d("123", "notify: "+datas);
    }
}