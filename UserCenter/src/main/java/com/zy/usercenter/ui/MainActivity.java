package com.zy.usercenter.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zy.usercenter.R;
import com.zy.usercenter.databinding.ActivityMainBinding;
import com.zy.usercenter.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

//        binding.setUser(user);
        rvMain = (RecyclerView) findViewById(R.id.rv_main);

        initRV(rvMain);
    }

    private void initRV(RecyclerView rvMain) {
        List<UserEntity> list=new ArrayList<>();
        for (int i=0;i<1000;i++){
            list.add(new UserEntity(1,""+i,"","",""));
        }
        RVAdapter adapter=new RVAdapter(this,list);


        LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);
        rvMain.setLayoutManager(llm);
        rvMain.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rvMain.setItemAnimator(new DefaultItemAnimator());
        rvMain.setAdapter(adapter);


    }

    class RVAdapter extends RecyclerView.Adapter<RVAdapter.RVHolder>{

        private Context mContext;
        private List<UserEntity> source;
        public RVAdapter(Context context,List<UserEntity> list){
            mContext=context;
            source=list;
        }

        @NonNull
        @Override
        public RVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_main, null);
            return new RVHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RVHolder holder, int position) {
            UserEntity testUserEntity = source.get(position);
            holder.tv_content.setText(testUserEntity.getUsername());
        }

        @Override
        public int getItemCount() {
            return source.size();
        }

        public class RVHolder extends RecyclerView.ViewHolder {
            private TextView tv_content;
            public RVHolder(@NonNull View itemView) {
                super(itemView);
                tv_content=itemView.findViewById(R.id.tv_item_main_content);
            }
        }
    }
}