package com.zy.mvvm.ui.adapter;

import android.view.View;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.UNINITIALIZED_VALUE;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.mvvm.ui.adapter
 * @ClassName: BaseViewHolder
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/20 10:11
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/20 10:11
 * @UpdateRemark:
 * @Version: 1.0
 */
public abstract class BaseViewHolder extends RecyclerView.ViewHolder {
    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
        initView(itemView);
    }

    /**
     * 处理FindViewById
     * @param
     * @return 
     * @author zhangyue
     * @time 2021/11/20 10:13
     */ 
    protected abstract void initView(View itemView);

}
