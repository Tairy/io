package com.sqkb.singleton;

/**
 * package: com.sqkb.singleton
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/11/30 上午9:56
 *
 * 每次 getInstance 都需要加锁, 性能不高
 */
public class SimpleMultithreadedSingleton {
    public static SimpleMultithreadedSingleton INSTANCE = null;

    private SimpleMultithreadedSingleton() {
    }

    public static SimpleMultithreadedSingleton getInstance() {
        synchronized (SimpleMultithreadedSingleton.class) {
            if (null == INSTANCE) {
                INSTANCE = new SimpleMultithreadedSingleton();
            }

            return INSTANCE;
        }
    }
}