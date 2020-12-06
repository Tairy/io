package com.sqkb;

/**
 * package: com.sqkb
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/11/29 下午1:48
 */
public class Visibility {
    public static void main(String[] args) {
        TimeConsumingTask timeConsumingTask = new TimeConsumingTask();
        Thread thread = new Thread(timeConsumingTask);
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timeConsumingTask.cancel();
    }

    static class TimeConsumingTask implements Runnable {
        private boolean toCancel = false;

        @Override
        public void run() {
            while (!toCancel) {
                if (doExecute()) {
                    break;
                }
            }

            if (toCancel) {
                System.out.println("Task was canceled!");
            } else {
                System.out.println("Task done.");
            }
        }

        private boolean doExecute() {
            boolean isDone = false;
            System.out.println("executing...");
            try {
                long t = (long) (Math.random() * 5);
                Thread.sleep(t);
            } catch (Exception e) {

            }

            return isDone;
        }

        public void cancel() {
            toCancel = true;
            System.out.println(this + " canceled.");
        }
    }
}