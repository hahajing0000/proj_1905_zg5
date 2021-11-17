package com.zy.mvvm.observ;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.mvvm.observ
 * @ClassName: BaseObserver
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/17 19:04
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/17 19:04
 * @UpdateRemark:
 * @Version: 1.0
 */
public class BaseObserver<T> implements Observer<T> {
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
