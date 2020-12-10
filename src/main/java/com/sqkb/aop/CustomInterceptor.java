package com.sqkb.aop;

import java.lang.reflect.InvocationTargetException;

/**
 * package: com.sqkb.aop
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/12/10 上午9:23
 */
public class CustomInterceptor implements Interceptor {
    @Override
    public boolean before() {
        System.out.println("before.....");
        return true;
    }

    @Override
    public void after() {
        System.out.println("after......");
    }

    @Override
    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        System.out.println("around before......");

        Object obj = invocation.processed();

        System.out.println("around after....");
        return obj;
    }

    @Override
    public void afterReturning() {
        System.out.println("after returning....");
    }

    @Override
    public void afterThrowing() {
        System.out.println("after throwing.....");
    }

    @Override
    public boolean useAround() {
        return true;
    }
}