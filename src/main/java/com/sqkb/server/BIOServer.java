package com.sqkb.server;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * package: com.sqkb.Service
 * 基本的 BIO 模式
 * c/s 1:1 通信
 *
 * @author <fangzhang> fangzhang@ibantang.com
 * @date 2019-09-04 18:27
 */
public class BIOServer {
    /**
     * 处理 socket 请求
     *
     * @param socket socket 对象
     */
    public static void handle(Socket socket) {
        try {
            byte[] bytes = new byte[1024];

            InputStream inputStream = socket.getInputStream();

            while (true) {
                int reader = inputStream.read(bytes);

                if (reader != -1) {
                    System.out.println(new String(bytes, 0, reader));
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.println("socket close");
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 入口函数
     */
    public static void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("bio server start on 12345");

            while (true) {
                final Socket socket = serverSocket.accept();
                System.out.println("connect come");
                handle(socket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
