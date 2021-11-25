package com.zy.home.view;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SocketServerService extends Service {

    private ServerSocket serverSocket;

    private List<Socket> socketList=new ArrayList<>();

    private Executor mExecutor= Executors.newCachedThreadPool();
    private Socket socket;

    public SocketServerService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startSocketServer();
        return START_STICKY;
    }

    /**
     * 创建Socket服务器端并监听指定端口
     * @param
     * @return 
     * @author zhangyue
     * @time 2021/11/25 15:42
     */ 
    private void startSocketServer(){
        try {
            serverSocket = new ServerSocket(8090);
            mExecutor.execute(new SocketRunnable(socket));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class SocketRunnable implements Runnable {

        public SocketRunnable(Socket socket) {

        }

        @Override
        public void run() {
            try {
                while (true){
                    /**
                     * 接收客户端链接，没有则阻塞
                     */
                    socket = serverSocket.accept();
                    socket.setKeepAlive(true);
                    //运行发送紧急数据
//                    socket.sendUrgentData();
                    socket.setOOBInline(true);
                    //读取数据时阻塞的超时时间
                    socket.setSoTimeout(60*1000);
                    Log.d("123", "run: ................");
                    socketList.add(socket);
                    DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                    DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                    while (true){
                        /**
                         * 读取客户端消息
                         */
                        String clientContent = dataInputStream.readUTF();
                        Log.d("123", "收到客户端消息："+clientContent);
                        if (clientContent.equals("\r\n")){
                            /**
                             * 给客户端发送消息
                             */
                            dataOutputStream.writeUTF("服务器端收到心跳包。。。。");
                            dataOutputStream.flush();
                        }else{
                            /**
                             * 给客户端发送消息
                             */
                            dataOutputStream.writeUTF("服务器端收到消息");
                            dataOutputStream.flush();
                        }

                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
