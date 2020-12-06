package com.sqkb.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * package: com.sqkb.gc
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/12/2 上午11:14
 */
public class HeapTest {
    public static void main(String[] args) {
        List<HeapTest> heapTests = new ArrayList<>();
        while (true) {
            heapTests.add(new HeapTest());
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}