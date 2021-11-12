package com.zy.utils;

import android.os.Looper;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import androidx.arch.core.executor.DefaultTaskExecutor;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.utils
 * @ClassName: ThreadUtils
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/12 13:22
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/12 13:22
 * @UpdateRemark:
 * @Version: 1.0
 */
public class ThreadUtils {

    /**
     * 1-核心线程数
     * 2-线程池总数
     * 3-非核心线程数的存活时间
     * 4-存活时间单位
     * 5-阻塞队列
     * 6-创建线程的工厂
     */
    static ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(0, Integer.MAX_VALUE, 15, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r);
        }
    });

    /**
     * 是否在主线程 True 是 False 否
     * @param
     * @return 
     * @author zhangyue
     * @time 2021/11/12 13:23
     */ 
    public static boolean isMainThread(){
        if (Looper.getMainLooper().getThread()==Thread.currentThread()){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 使用线程池执行任务
     * @param
     * @return 
     * @author zhangyue
     * @time 2021/11/12 13:29
     */ 
    public static void runTask(Runnable task){
        threadPoolExecutor.submit(task);
    }
}
