package com.sqkb;

import com.sqkb.thread.CustomThread;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        BIOServer.run();
//        BIOServerWithThreadPool.run();
//        NIOServer.run();

        CustomThread customThread = new CustomThread();
        customThread.setName("just-test-thread");
        customThread.start();
        try {

            for (int i = 0; i < 10; i++) {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("main = " + Thread.currentThread().getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
