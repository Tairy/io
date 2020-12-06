package com.sqkb.singleton;

/**
 * package: com.sqkb.singleton
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/11/30 上午10:04
 */
public class StaticHolderSingleton {
    private StaticHolderSingleton() {
    }

    private static class InstanceHolder {
        final static StaticHolderSingleton INSTANCE = new StaticHolderSingleton();
    }

    // 利用 JVM 初始化静态类的特性实现, 保证 INSTANCE 对象只被创建一次
    public static StaticHolderSingleton getInstance() {
        return InstanceHolder.INSTANCE;
    }
}