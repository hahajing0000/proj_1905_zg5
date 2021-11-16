package com.zy.mvvmcore.repository;

import com.zy.mvvmcore.common.InjectModel;
import com.zy.mvvmcore.exception.MVVMRepositoryException;
import com.zy.mvvmcore.model.IModel;

import java.lang.reflect.Field;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.mvvmcore.repository
 * @ClassName: BaseRepository
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/12 10:55
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/12 10:55
 * @UpdateRemark:
 * @Version: 1.0
 */
public abstract class BaseRepository {

    public BaseRepository(){
        /**
         * 找到子类具有InjectModel注解字段 然后实例化 并赋值给当前字段
         */
        inject();
    }

    /**
     * 找到子类具有InjectModel注解字段 然后实例化 并赋值给当前字段
     */
    private void inject() {
//        //只能获取 到当前类 的 public的字段和父类 public的字段
//        Field[] fields = getClass().getFields();
        boolean flag=false;
        //能获取当前类的所有字段但是不能获取上层类的任何字段
        Field[] allFields = getClass().getDeclaredFields();
        for (Field field:allFields){
            InjectModel annotation = field.getAnnotation(InjectModel.class);
            if (annotation!=null){
                flag=true;
                field.setAccessible(true);
//                Class<?> declaringClass = field.getDeclaringClass();

                String fieldClassName= field.getType().getName();
                try {
                    Class<?> aClass = Class.forName(fieldClassName);
                    Object fieldInstance = aClass.newInstance();
                    field.set(this,fieldInstance);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        if (!flag){
            throw new MVVMRepositoryException("not find field by InjectModel...");
        }

    }
}
