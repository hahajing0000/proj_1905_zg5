package com.zy.utils.log;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.utils.log
 * @ClassName: LogUtils
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/13 11:24
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/13 11:24
 * @UpdateRemark:
 * @Version: 1.0
 */
public class LogUtils {
    private static LogUtils instance=new LogUtils();
    private LogUtils(){}
    public static LogUtils getInstance(){
        return instance;
    }

    private Logger logger;
    public void init(Logger _logger){
        this.logger=_logger;
    }

    public void writeLog(LogType type, String log) {
        this.logger.writeLog(type,log);
    }
}
