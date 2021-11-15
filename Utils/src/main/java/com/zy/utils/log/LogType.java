package com.zy.utils.log;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.utils.log
 * @ClassName: LogType
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/13 10:56
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/13 10:56
 * @UpdateRemark:
 * @Version: 1.0
 */
public enum LogType {
    Info(1),Debug(2),Warnning(3),Error(4);
    private int value=1;
    LogType(int i){
        this.value=i;
    }
}
