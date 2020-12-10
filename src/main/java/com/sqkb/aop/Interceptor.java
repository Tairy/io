package com.sqkb.aop;

import java.lang.reflect.InvocationTargetException;

/**
 * package: com.sqkb.aop
 *
 * @author <fangzhang> fangzhang@ibantang.com
 * @date 2020-12-10 09:11
 */
public interface Interceptor {

    boolean before();

    void after();

    Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException;

    void afterReturning();

    void afterThrowing();

    boolean useAround();
}
