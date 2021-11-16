package com.zy.mvvmcore.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.mvvmcore.common
 * @ClassName: InjectModel
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/16 13:40
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/16 13:40
 * @UpdateRemark:
 * @Version: 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface InjectModel {
    String value() default "";
}
