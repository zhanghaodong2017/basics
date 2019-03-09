package com.zhd.basics.sockets;

import java.io.*;
import java.net.Socket;

/**
 * @Author: zhanghaodong
 * @Description
 * @Date: 2019-03-08 14:33
 */
public class DataHandler implements Runnable {

    public static final String CHARCODE = "utf-8";

    private Socket socket;

    public DataHandler(Socket socket) {
        this.socket = socket;
    }

    private PrintWriter getWriter(Socket socket) throws IOException {
        OutputStream socketOut = socket.getOutputStream();
        return new PrintWriter(socketOut, true);
    }

    private BufferedReader getReader(Socket socket) throws IOException {
        InputStream socketIn = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(socketIn));
    }

    public void run() {

        //开始处理数据
        BufferedReader br = null;
        PrintWriter out = null;
        try {
            br = getReader(socket);

            out = getWriter(socket);
            String msg = null;
            StringBuilder builder = new StringBuilder();
            while ((msg = br.readLine()) != null) {
                builder.append(msg);
            }
            out.println("ok");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (out != null) {
                out.close();
            }
        }
    }


}
