package com.zy.mvvm.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zy.mvvm.R;
import com.zy.mvvm.ui.adapter.BaseRecyclerViewAdapter;
import com.zy.mvvm.ui.adapter.BaseViewHolder;
import com.zy.usercenter.entity.UserEntity;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView rvRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        rvRecyclerview = (RecyclerView) findViewById(R.id.rv_recyclerview);

        List<UserEntity> userEntityList=new ArrayList<UserEntity>();
        for (int i=0;i<20;i++){
            userEntityList.add(new UserEntity(i,"用户"+i,"111","0",""));
        }

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);

        rvRecyclerview.setLayoutManager(linearLayoutManager);
        rvRecyclerview.setAdapter(new MyAdapter(this,userEntityList));
    }

    class MyAdapter extends BaseRecyclerViewAdapter<UserEntity, MyAdapter.MyViewHolder>{

        public MyAdapter(Context context, List<UserEntity> _list) {
            super(context, _list);
        }

        @Override
        protected int getLayoutId() {
            return R.layout.item_recyclerview_test;
        }

        @Override
        protected MyViewHolder createViewHolder(View view) {
            return new MyViewHolder(view);

        }



        @Override
        protected void bindVH(MyViewHolder holder, int position) {
            UserEntity userEntity = dataSource.get(position);
            holder.tv_username.setText(userEntity.getUsername());
            holder.tv_address.setText(userEntity.getPwd());
        }

        class MyViewHolder extends BaseViewHolder{
            private TextView tv_username;
            private TextView tv_address;
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
            }

            @Override
            protected void initView(View itemView) {
                tv_username=itemView.findViewById(R.id.tv_item_recyclerview_username);
                tv_address=itemView.findViewById(R.id.tv_item_recyclerview_address);
            }
        }
    }
}