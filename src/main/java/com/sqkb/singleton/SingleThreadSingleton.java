package com.sqkb.singleton;

/**
 * package: com.sqkb.singleton
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/11/30 上午9:53
 * <p>
 * 线程不安全
 */
public class SingleThreadSingleton {

    private static SingleThreadSingleton INSTANCE = null;

    private SingleThreadSingleton() {
    }

    public static SingleThreadSingleton getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new SingleThreadSingleton();
        }

        return INSTANCE;
    }
}