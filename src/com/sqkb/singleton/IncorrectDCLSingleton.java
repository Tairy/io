package com.sqkb.singleton;

/**
 * package: com.sqkb.singleton
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/11/30 上午9:58
 * <p>
 * 这种实现因为临界区的重新排序,会导致有可能调用方拿到错误的 INSTANCE 对象
 */
public class IncorrectDCLSingleton {
    private static IncorrectDCLSingleton INSTANCE;

    private IncorrectDCLSingleton() {
    }

    public static IncorrectDCLSingleton getInstance() {
        if (null == INSTANCE) {
            synchronized (IncorrectDCLSingleton.class) {
                if (null == INSTANCE) {
                    INSTANCE = new IncorrectDCLSingleton();
                }
            }
        }

        return INSTANCE;
    }
}