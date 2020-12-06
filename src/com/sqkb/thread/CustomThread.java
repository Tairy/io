package com.sqkb.thread;

/**
 * package: com.sqkb.thread
 *
 * @author <fangzhang> fangzhang@ibantang.com
 * @date 2019-09-09 18:26
 */
public class CustomThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                int time = (int) (Math.random() * 1000);

                Thread.sleep(time);

                System.out.println("run = " + Thread.currentThread().getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
