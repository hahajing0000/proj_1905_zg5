package com.zy.home.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.zy.home.R;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SocketActivity extends AppCompatActivity {
    private Button btnStartSocketServer;
    private Button btnCreateSocketClient;
    private Button btnSendMsg;


    private Executor mExecutor = Executors.newCachedThreadPool();
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socket);

        btnStartSocketServer = (Button) findViewById(R.id.btn_start_socket_server);

        btnCreateSocketClient = (Button) findViewById(R.id.btn_create_socket_client);

        btnSendMsg = (Button) findViewById(R.id.btn_send_msg);

        btnCreateSocketClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    initSocketClient();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        btnStartSocketServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(SocketActivity.this, SocketServerService.class));
            }
        });

        btnSendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMsg("????????????????????????"+ SystemClock.uptimeMillis());
            }
        });

    }

    /**
     * ????????????????????????
     * @param
     * @return 
     * @author zhangyue
     * @time 2021/11/25 15:41
     */ 
    private void sendMsg(String s) {
       mExecutor.execute(new Runnable() {
           @Override
           public void run() {
               try {
                   Log.i("123", "client send msg:"+s);
                   dataOutputStream.writeUTF(s);
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       });
    }

    /**
     * ??????Socket??????????????????????????????
     * @param
     * @return
     * @author zhangyue
     * @time 2021/11/25 15:40
     */
    private void initSocketClient() throws IOException {

        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Socket socket = null;
                    try {
                        /**
                         * IP????????????adb ???????????? ?????? adb shell ?????? ifconfig????????????ip??????????????????
                         */
                        socket = new Socket("192.168.232.2", 8090);
                        dataInputStream = new DataInputStream(socket.getInputStream());
                        dataOutputStream = new DataOutputStream(socket.getOutputStream());
                        /**
                         * ?????????????????????????????????
                         */
                        startHeartBeat();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    /**
                     * ???????????????????????????????????????
                     */
                    while (true){
                        String msg = dataInputStream.readUTF();
                        Log.d("123", "??????????????????: " + msg);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    /**
     * ????????????
     * @param
     * @return
     * @author zhangyue
     * @time 2021/11/25 15:49
     */
    private void startHeartBeat() {
        ScheduledThreadPoolExecutor executor=new ScheduledThreadPoolExecutor(2);
        /**
         * ???????????????????????????Socket??????????????????????????????????????? ??????????????????????????????60??? ???????????????40???
         */
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                sendMsg("\r\n");
            }
        },0,40, TimeUnit.SECONDS);
    }
}