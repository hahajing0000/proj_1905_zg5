package com.zy.utils.log;

import com.zy.utils.log.impl.LocalImpl;
import com.zy.utils.log.impl.LogcatImpl;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.utils.log
 * @ClassName: Logger
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/13 11:02
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/13 11:02
 * @UpdateRemark:
 * @Version: 1.0
 */
public class Logger implements ILog {

    private ILog logger;
    private boolean isDebug=false;
    private LogStrategy logStrategy=LogStrategy.Logcat;
    private LogType  logType=LogType.Info;
    public Logger(boolean isDedug,LogStrategy logStrategy,LogType logType){

        this.isDebug=isDedug;
        this.logStrategy=logStrategy;
        this.logType=logType;

        logger= createLoggerInstance(logStrategy);
    }

    private ILog createLoggerInstance(LogStrategy logStrategy) {
        switch (logStrategy){
            case Logcat:
                logger=new LogcatImpl();
                break;
            case Local:
                logger=new LocalImpl();
                break;
            case Email:

                break;
            case Server:
                break;
        }
        return logger;
    }

    @Override
    public void writeLog(LogType type, String log) {
        if (isDebug){
            logger.writeLog(type,log);
        }
    }

    public  static class Builder{
        private boolean isDebug=false;
        private LogStrategy logStrategy=LogStrategy.Logcat;
        private LogType minLogType=LogType.Info;

        public Builder setDebug(boolean isDebug){
            this.isDebug=isDebug;
            return this;
        }

        public Builder setLogStrategy(LogStrategy logStrategy){
            this.logStrategy=logStrategy;
            return this;
        }

        public Builder setMinLogType(LogType logType){
            this.minLogType=logType;
            return this;
        }

        public Logger build(){
            return new Logger(isDebug,logStrategy,minLogType);
        }
    }
}
