package com.sqkb.threadpool;

import java.util.concurrent.*;

/**
 * package: com.sqkb.threadpool
 *
 * @author <fangzhang> fangzhang@ibantang.com
 * @date 2020-12-06 10:34
 */
public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
//        ExecutorService executorService = new ThreadPoolExecutor(
//                4,
//                4000,
//                0L,
//                TimeUnit.SECONDS,
//                new LinkedBlockingDeque<Runnable>(100)
//        );
//
//        for (int i = 0; i < 10000; i++) {
//            executorService.execute(() -> {
//                System.out.println(Thread.currentThread().getName());
//            });
//        }
//
//
//        executorService.shutdown();
//        executorService.shutdownNow();

//        Future<String> result = executorService.submit(() -> {
//            System.out.println(Thread.currentThread().getName());
//            return "success";
//        });
//
//        try {
//            System.out.println(result.get());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
