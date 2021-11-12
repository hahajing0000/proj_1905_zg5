package com.zy.mvvmcore.exception;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.mvvmcore.exception
 * @ClassName: MVVMNormalException
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/12 11:28
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/12 11:28
 * @UpdateRemark:
 * @Version: 1.0
 */
public class MVVMNormalException extends RuntimeException {
    public MVVMNormalException(String content){
        super(content);
    }
}
