package com.zhd.basics.sockets;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MultiThreadServer {
    private final int POOL_SIZE = 1;
    private final int maximumPoolSize = 30;
    private final long keepAliveTime = 60;
    private int port = 9999;
    private ServerSocket serverSocket;
    private ExecutorService executorService;

    public MultiThreadServer() throws IOException {
        serverSocket = new ServerSocket(port);
        executorService = new ThreadPoolExecutor(POOL_SIZE,
                maximumPoolSize, keepAliveTime, TimeUnit.MINUTES,
                new ArrayBlockingQueue<Runnable>(30));

        System.out.println("服务已启动");
    }

    public static void main(String[] args) throws IOException {
        new MultiThreadServer().service();
    }

    public void service() {
        while (true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                executorService.execute(new DataHandler(socket));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
