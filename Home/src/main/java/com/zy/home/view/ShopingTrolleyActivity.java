package com.zy.home.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.zy.home.R;
import com.zy.home.entity.ShopingTrolleyEntity;
import com.zy.home.entity.UIShopingTrolleyEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShopingTrolleyActivity extends AppCompatActivity {
    private RecyclerView rvShopingtrolley;
    private CheckBox cbShopingtrolleyCheckall;
    private TextView txtShopingtrolleySumvalue;
    private Button btnJs;


    private List<UIShopingTrolleyEntity> dataSource=null;
    private ShopingTrolleyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        initView();

        initData();

        initEvent();
    }

    private void initView() {
        rvShopingtrolley = (RecyclerView) findViewById(R.id.rv_shopingtrolley);
        cbShopingtrolleyCheckall = (CheckBox) findViewById(R.id.cb_shopingtrolley_checkall);
        txtShopingtrolleySumvalue = (TextView) findViewById(R.id.txt_shopingtrolley_sumvalue);


        btnJs = (Button) findViewById(R.id.btn_js);
    }

    private void initData() {

        this.dataSource=createDataSource();

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);

        rvShopingtrolley.setLayoutManager(linearLayoutManager);
        rvShopingtrolley.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));
        adapter = new ShopingTrolleyAdapter(dataSource);


//        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
//            @Override
//            public void onChanged() {
//                super.onChanged();
//                Log.d("123", "onChanged: .......");
//            }
//        });

        rvShopingtrolley.setAdapter(adapter);
    }

    private List<UIShopingTrolleyEntity> createDataSource() {
        List<UIShopingTrolleyEntity> _dataSource=new ArrayList<>();
        Random random = new Random();


        for (int i=0;i<10;i++){
            _dataSource.add(new UIShopingTrolleyEntity(i,i,"商品"+i,"",random.nextFloat(), random.nextInt(5),0));
        }

        return _dataSource;
    }

    private void initEvent() {
        btnJs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int size = dataSource.size();
                Log.d("123", "onClick: "+size);
            }
        });

        cbShopingtrolleyCheckall.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Object tag = buttonView.getTag();
//                Object tag = cbShopingtrolleyCheckall.getTag();
                if (tag!=null&&(Boolean) tag){
                    return;
                }
                if (isChecked){
                    checkdAll(true);
                }else {
                    checkdAll(false);
                }
            }
        });

    }

    class ShopingTrolleyAdapter extends RecyclerView.Adapter<ShopingTrolleyAdapter.ViewHolder>{
        private List<UIShopingTrolleyEntity> mDataSource=null;
        public ShopingTrolleyAdapter(List<UIShopingTrolleyEntity> _dataSource){
            mDataSource=_dataSource;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shopingtrolley, null);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            UIShopingTrolleyEntity data = mDataSource.get(position);
            holder.cbItemShopingtrolley.setChecked(data.isChecked());
            holder.cbItemShopingtrolley.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    data.setChecked(isChecked);
//                    if (rvShopingtrolley.isComputingLayout()){
//                        rvShopingtrolley.post(new Runnable() {
//                            @Override
//                            public void run() {
//                                data.setChecked(isChecked);
////                                ShopingTrolleyAdapter.this.notifyItemChanged(position);
//                            }
//                        });
//                    }else{
//                        data.setChecked(isChecked);
////                        ShopingTrolleyAdapter.this.notifyDataSetChanged();
//                    }
                    notifyPropChanged();
                }
            });
            holder.txtItemShopingtrolleyTitle.setText(data.getGoodsName());
            holder.txtItemShopingtrolleyPrice.setText(String.valueOf(data.getGoodsPrice()));
            holder.txtItemShopingtrolleyNumber.setText(String.valueOf(data.getGoodsNumber()));
            holder.txtItemShopingtrolleySubtract.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    data.setGoodsNumber(data.getGoodsNumber()-1);
                    //局部刷新
                    ShopingTrolleyAdapter.this.notifyItemChanged(position);

                    if (holder.cbItemShopingtrolley.isChecked()){
                        notifyPropChanged();
                    }
                }
            });

            holder.txtItemShopingtrolleyPlus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    data.setGoodsNumber(data.getGoodsNumber()+1);
                    //局部刷新
                    ShopingTrolleyAdapter.this.notifyItemChanged(position);

                    if (holder.cbItemShopingtrolley.isChecked()){
                        notifyPropChanged();
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return mDataSource.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder{
            private CheckBox cbItemShopingtrolley;
            private TextView txtItemShopingtrolleyTitle;
            private TextView txtItemShopingtrolleyPrice;
            private TextView txtItemShopingtrolleySubtract;
            private EditText txtItemShopingtrolleyNumber;
            private TextView txtItemShopingtrolleyPlus;



            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                cbItemShopingtrolley = (CheckBox) itemView.findViewById(R.id.cb_item_shopingtrolley);
                txtItemShopingtrolleyTitle = (TextView) itemView.findViewById(R.id.txt_item_shopingtrolley_title);
                txtItemShopingtrolleyPrice = (TextView) itemView.findViewById(R.id.txt_item_shopingtrolley_price);
                txtItemShopingtrolleySubtract = (TextView) itemView.findViewById(R.id.txt_item_shopingtrolley_subtract);
                txtItemShopingtrolleyNumber = (EditText) itemView.findViewById(R.id.txt_item_shopingtrolley_number);
                txtItemShopingtrolleyPlus = (TextView) itemView.findViewById(R.id.txt_item_shopingtrolley_plus);
            }
        }
    }

    /**
     * 数据集合属性变更
     * @param
     * @return 
     * @author zhangyue
     * @time 2021/11/26 13:11
     */ 
    private void notifyPropChanged() {
        float sumValue=0.0f;
        boolean flag=false;
        for (UIShopingTrolleyEntity entity:dataSource){
            if (entity.isChecked()){
                sumValue+=entity.getTotalPrice();
            }
            else{
                flag=true;
            }
        }
        if (flag){
            cbShopingtrolleyCheckall.setTag(true);
            cbShopingtrolleyCheckall.setChecked(false);
        }else{
            cbShopingtrolleyCheckall.setTag(false);
            cbShopingtrolleyCheckall.setChecked(true);
        }
        txtShopingtrolleySumvalue.setText(String.valueOf(sumValue));
    }


    /**
     * 全选或者取消选中
     * @param
     * @return 
     * @author zhangyue
     * @time 2021/11/26 13:16
     */ 
    private void checkdAll(boolean b) {
        for (UIShopingTrolleyEntity entity:dataSource){
            entity.setChecked(b);

        }
        adapter.notifyDataSetChanged();
        notifyPropChanged();
    }


}