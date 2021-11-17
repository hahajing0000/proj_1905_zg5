package com.zy.mvvm.observ;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.mvvm.observ
 * @ClassName: IObserver
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/17 18:37
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/17 18:37
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface IObserver {
    void notify(Object... datas);
}
