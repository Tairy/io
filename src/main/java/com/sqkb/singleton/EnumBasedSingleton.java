package com.sqkb.singleton;

/**
 * package: com.sqkb.singleton
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/11/30 上午10:06
 */
public class EnumBasedSingleton {
    // Singleton 枚举类型相当与是单例类
    public static enum Singleton {
        INSTANCE;

        Singleton() {
        }
    }
}