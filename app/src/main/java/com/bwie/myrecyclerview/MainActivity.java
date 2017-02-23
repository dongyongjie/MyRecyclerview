package com.bwie.myrecyclerview;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.bwie.myrecyclerview.adapter.RvAdapter;
import com.bwie.myrecyclerview.adapter.RvAdapter2;
import com.bwie.myrecyclerview.bean.RootBean;
import com.bwie.myrecyclerview.bean.Rs;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;
    private OkHttpClient okHttpClient;
    private Request request;
    private List<Rs> list;
    private Handler handler=new Handler(){

        private RvAdapter adapter;

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    adapter = new RvAdapter(MainActivity.this, list);
                    recyclerView1.setAdapter(adapter);
                    get2(0);
                    adapter.setOnItemClickListener(new RvAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClickListener(View viewHolder, int pos) {
                            get2(pos);
                        }
                    });
                break;
                case 1:
                    break;
            }
        }
    };

    private void get2(int pos) {
        recyclerView2.setAdapter(new RvAdapter2(MainActivity.this,list.get(pos).getChildren()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        recyclerView1 = (RecyclerView) findViewById(R.id.recyclerView1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView2 = (RecyclerView) findViewById(R.id.recyclerView2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        okHttpClient = new OkHttpClient()
                .newBuilder()
                .build();
        request = new Request.Builder()
                .url("http://mock.eoapi.cn/success/4q69ckcRaBdxhdHySqp2Mnxdju5Z8Yr4")
                .header("User-Agent","OkHttp Example")
                .build();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    get1();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void get1() throws IOException {
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {



            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("zgx","response====="+e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                Log.d("zgx","response====="+response.body().string());
                Gson gson = new Gson();
                RootBean bean = gson.fromJson(response.body().string(), RootBean.class);

                list = bean.getRs();
                Message msg=new Message();
                handler.sendMessage(msg);
//                Log.i("TAG", "onResponse: "+bean.toString());

                response.body().close();
            }
        });
    }
}
