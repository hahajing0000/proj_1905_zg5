package com.zy.mvvm.observ;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.mvvm.observ
 * @ClassName: ObservManager
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/17 18:40
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/17 18:40
 * @UpdateRemark:
 * @Version: 1.0
 */
public class ObservManager {
    private static ObservManager instance=null;
    private ObservManager(){
        observable=new Observable();
    }
    private static class HOLDER{
        private static ObservManager INSTANCE=new ObservManager();
    }

    Observable observable;

    public static ObservManager getInstance(){
        return HOLDER.INSTANCE;
    }

    public void register(IObserver observer){
        observable.register(observer);
    }

    public void unRegister(IObserver observer){
        observable.unRegister(observer);
    }

    public void notifyAll(Object... datas){
        observable.notifyAll(datas);
    }
}
