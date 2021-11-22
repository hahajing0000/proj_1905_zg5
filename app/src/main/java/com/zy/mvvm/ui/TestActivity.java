package com.zy.mvvm.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.ResponseBody;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.LruCache;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.zy.mvvm.R;
import com.zy.mvvm.wiget.NewProgressView;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestActivity extends AppCompatActivity {

//    int maxSize= (int) (Runtime.getRuntime().totalMemory()/8);
    //        if (lruCache.get("111")==null){
//            if (diskLruCache.get("111")==null){
//                retrofit.create(Api.class).enqueue(new Callback(){
//                   void onResponse(ResponseBody body){
//                       diskLruCache.put("111",body.string());
//                       lruCache.put("111",body.string());
//                   }
//                });
//            }
//            else{
//                lruCache.put("111",body.string());
//                return;
//            }
//        }else{
//            return;
//        }

//        LruCache<String, String> lruCache=new LruCache<>(maxSize);
//
//        lruCache.put("11","22222");
//        String s = lruCache.get("11");
//
//        Log.d("123", "onCreate: "+s);

//        LinkedHashMap<String,String> linkedHashMap=new LinkedHashMap<>(0,0.75f,true);
//
//        linkedHashMap.put("11","11");
//        linkedHashMap.put("22","22");
//        linkedHashMap.put("33","33");
//
//        linkedHashMap.get("22");
//        linkedHashMap.get("11");
//
//        for (Map.Entry<String,String> entry:linkedHashMap.entrySet()){
//            Log.d("123", String.format("key=%s value=%s",entry.getKey(),entry.getValue()));
//        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        startActivity(new Intent(this,DialogActivity.class));
//        mHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                    startActivity(new Intent(TestActivity.this,Test2Activity.class), ActivityOptions.makeSceneTransitionAnimation(TestActivity.this,
//                            Pair.create(findViewById(R.id.iv_1),"image")).toBundle());
//                }
//            }
//        },3000);



//        new Object();//GCRoots
//
//        SoftReference<String> softReference=new SoftReference<String>("11");

//        ReferenceQueue<Activity> referenceQueue=new ReferenceQueue<>();
//
//        WeakReference<Activity> weakReference1=new WeakReference<Activity>("11",referenceQueue);
//        WeakReference<Activity> weakReference2=new WeakReference<Activity>("11",referenceQueue);
//        WeakReference<Activity> weakReference3=new WeakReference<Activity>("11",referenceQueue);
//        WeakReference<Activity> weakReference4=new WeakReference<Activity>("11",referenceQueue);
//        WeakReference<Activity> weakReference5=new WeakReference<Activity>("11",referenceQueue);

//      SharedPre...  commit(); apply();

//        mHanlder.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Log.d("123", "run: .....");
//                mHanlder.postDelayed(this,1000);
//            }
//        },1000);

//        ListView listView=new ListView(this);
//        listView.setAdapter(new TestAdapter());

//        RecyclerView recyclerView=new RecyclerView(this);
//
//        recyclerView.setAdapter();
    }

    private Handler mHandler=new Handler();

//    class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHolder>{
//        @NonNull
//        @Override
//        public TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//            View view = LayoutInflater.from(parent.getContext()).inflate(0, null);
//
//            return new TestViewHolder(view);
//        }
//
//        @Override
//        public void onBindViewHolder(@NonNull TestViewHolder holder, int position) {
//            holder.btn.setText(list.get(position).getName());
//        }
//
//        @Override
//        public int getItemCount() {
//            return 0;
//        }
//
//        static class TestViewHolder extends RecyclerView.ViewHolder{
//            private TextView textView;
//            private Button btn;
//            public TestViewHolder(@NonNull View itemView) {
//                super(itemView);
//
//            }
//        }
//    }

//    class TestAdapter extends BaseAdapter{
//
//        @Override
//        public int getCount() {
//            return list.size();
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return list.get(position);
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return position;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            if (convertView==null){
//                convertView.setTag(new ViewHolder());
//            }
//
//
//
//
//            return convertView;
//        }
//    }
//
//    class ViewHolder{
//    }

//    private Handler mHanlder=new Handler();

}