package com.zy.mvvmcore.exception;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.mvvmcore.exception
 * @ClassName: MVVMRepositoryException
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/16 14:00
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/16 14:00
 * @UpdateRemark:
 * @Version: 1.0
 */
public class MVVMRepositoryException extends IllegalStateException {
    public MVVMRepositoryException(String exception){
        super(exception);
    }
}
