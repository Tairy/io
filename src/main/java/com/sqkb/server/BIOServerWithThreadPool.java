package com.sqkb.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * package: com.sqkb.Service
 *
 * @author <fangzhang> fangzhang@ibantang.com
 * @date 2019-09-04 18:39
 */
public class BIOServerWithThreadPool {

    public static void run() {
        try {
            ExecutorService executorService = Executors.newCachedThreadPool();
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("bio server with thread pool start on 12345");
            while (true) {
                final Socket socket = serverSocket.accept();
                executorService.execute(() -> BIOServer.handle(socket));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
