package com.sqkb.singleton;

/**
 * package: com.sqkb.singleton
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/11/30 上午10:02
 */
public class DCLSingleton {

    private static volatile DCLSingleton INSTANCE;

    private DCLSingleton() {
    }

    public static DCLSingleton getInstance() {
        if (null == INSTANCE) {
            synchronized (DCLSingleton.class) {
                if (null == INSTANCE) {
                    // volatile 关键字会禁止临界区重新排序
                    INSTANCE = new DCLSingleton();
                }
            }
        }

        return INSTANCE;
    }
}