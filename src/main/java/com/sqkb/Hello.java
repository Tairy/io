package com.sqkb;

/**
 * package: com.sqkb
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/11/11 上午9:34
 */
public class Hello {

    public static void main(String[] args) throws Throwable {
        Thread currentThread = Thread.currentThread();

        String currentThreadName = currentThread.getName();
        System.out.printf("main method thread: %s\n", currentThreadName);
        Helper helper = new Helper("hhh");
        Thread helperThread = new Thread(helper);
//        helper.run();
        helperThread.start();
//        helperThread.run();

        MyThread myThread = new MyThread();
        myThread.start();
//        myThread.run();
    }

    static class Helper implements Runnable {

        private final String message;

        Helper(String message) {
            this.message = message;
        }

        @Override
        public void run() {
            Thread currentThread = Thread.currentThread();

            String currentThreadName = currentThread.getName();
            System.out.printf("helper method thread: %s\n", currentThreadName);
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.printf("i'am %s\n", Thread.currentThread().getName());
        while (true) {
        }
    }
}