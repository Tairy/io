package com.sqkb;

/**
 * package: com.sqkb
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/11/29 上午11:54
 */
public class RaceCondition {

    public static void main(String[] args) {
//        int numOfThreads = Runtime.getRuntime().availableProcessors();
        int numOfThreads = 4;
        System.out.printf("num_of_thread: %d%n", numOfThreads);
        Thread[] workThreads = new Thread[numOfThreads];
        for (int i = 0; i < numOfThreads; i++) {
            workThreads[i] = new WorkThread(i, 10);
        }
        for (Thread thread : workThreads) {
            thread.start();
        }
    }

    static class WorkThread extends Thread {
        private final int requestCount;

        WorkThread(int id, int requestCount) {
            super("worker-" + id);
            this.requestCount = requestCount;
        }

        @Override
        public void run() {
            int i = requestCount;
            String requestId;

            RequestIDGenerator requestIDGenerator = RequestIDGenerator.getInstance();
            while (i-- > 0) {
                requestId = requestIDGenerator.nextId();
                processRequest(requestId);
            }
        }

        private void processRequest(String requestId) {
            try {
                long t = (long) (Math.random() * 5);
                Thread.sleep(t);
                System.out.printf("%s got requestId: %s %n", Thread.currentThread().getName(), requestId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}