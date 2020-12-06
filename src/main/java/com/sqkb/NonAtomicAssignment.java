package com.sqkb;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * package: PACKAGE_NAME
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/11/29 下午1:05
 */
public class NonAtomicAssignment implements Runnable {

    static long value = 0;

    private final long valueToSet;

    public NonAtomicAssignment(long valueToSet) {
        this.valueToSet = valueToSet;
    }

    public static void main(String[] args) {
        Thread updateThread1 = new Thread(new NonAtomicAssignment(0L));
        Thread updateThread2 = new Thread(new NonAtomicAssignment(-1L));

        PrintStream printStream = new PrintStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {

            }
        });

        updateThread1.start();
        updateThread2.start();

        long snapshot;

        while (0 == (snapshot = value) || -1 == snapshot) {
            printStream.print(snapshot);
        }

        System.err.printf("Unexpected data: %d(0x%016x)", snapshot, snapshot);
        printStream.close();
        System.exit(0);
    }

    @Override
    public void run() {
        for (; ; ) {
            value = valueToSet;
        }
    }
}