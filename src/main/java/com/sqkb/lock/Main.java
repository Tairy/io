package com.sqkb.lock;

import org.openjdk.jol.info.ClassLayout;

/**
 * package: com.sqkb.lock
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/12/5 上午9:26
 */
public class Main {

    //    static final Object o = new Object();
    static int i;

//    public static void incr() {
//        while (i <= 30) {
//            synchronized (o) {
//                System.out.printf("%s-i: %d\n", Thread.currentThread().getName(), i);
//                i++;
//
//                try {
//                    o.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    public synchronized static void incr_v2() {
//        while (i <= 30) {
//            System.out.printf("%s-i: %d\n", Thread.currentThread().getName(), i);
//            i++;
//            try {
//                o.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    public static void main(String[] args) {
//        Object o1 = new Object();
//        System.out.println(Thread.currentThread().getId() + ":\n" + ClassLayout.parseInstance(o1).toPrintable());
//
//        synchronized (o1) {
//            System.out.println(Thread.currentThread().getId() + ":\n" + ClassLayout.parseInstance(o1).toPrintable());
//        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        final Object o = new Object();
        System.out.println(Thread.currentThread().getId() + ":\n" + ClassLayout.parseInstance(o).toPrintable());

        // 偏向锁
        synchronized (o) {
            System.out.println(Thread.currentThread().getId() + ":\n" + ClassLayout.parseInstance(o).toPrintable());
        }

        // 偏向锁 -> 重量级锁
        new Thread(() -> {
            synchronized (o) {
                System.out.println(Thread.currentThread().getId() + ":\n" + ClassLayout.parseInstance(o).toPrintable());
            }
        }).start();

        // 偏向锁 -> 重量级锁
        new Thread(() -> {
            synchronized (o) {
                System.out.println(Thread.currentThread().getId() + ":\n" + ClassLayout.parseInstance(o).toPrintable());
            }
        }).start();

        new Thread(() -> {
            synchronized (o) {
                System.out.println(Thread.currentThread().getId() + ":\n" + ClassLayout.parseInstance(o).toPrintable());
            }
        }).start();
    }
}