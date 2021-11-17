package com.zy.mvvm.observ;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.mvvm.observ
 * @ClassName: Observable
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/17 18:38
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/17 18:38
 * @UpdateRemark:
 * @Version: 1.0
 */
public class Observable {
    private List<IObserver> list;
    public Observable(){
        list=new ArrayList<>();
    }

    public void register(IObserver observer){
        list.add(observer);
    }

    public void unRegister(IObserver observer){
        list.remove(observer);
    }

    public void notifyAll(Object... datas){
        for (IObserver observer:list){
            observer.notify(datas);
        }
    }
}
