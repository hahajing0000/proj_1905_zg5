package com.zy.mvvm.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.ref.WeakReference;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.mvvm.ui.adapter
 * @ClassName: BaseRecyclerViewAdapter
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/20 10:10
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/20 10:10
 * @UpdateRemark:
 * @Version: 1.0
 */
public abstract class BaseRecyclerViewAdapter<T,VH extends BaseViewHolder> extends RecyclerView.Adapter<VH> {
    protected List<T> dataSource;
    protected WeakReference<Context> contextRef;
    public BaseRecyclerViewAdapter(Context context,List<T> _list){
        this.dataSource=_list;
        this.contextRef=new WeakReference<>(context);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(contextRef.get()).inflate(getLayoutId(), null);
        return createViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        bindVH(holder,position);
    }

    @Override
    public int getItemCount() {
        if (dataSource==null){
            return 0;
        }
        return this.dataSource.size();
    }

    protected abstract int getLayoutId();

    protected abstract VH createViewHolder(View view);

    protected abstract void bindVH(VH holder, int position);
}
