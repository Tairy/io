package com.sqkb.aop;

/**
 * package: com.sqkb.aop
 *
 * @author <fangzhang> fangzhang@ibantang.com
 * @date 2020-12-10 09:11
 */
public interface Interceptor {

    public boolean before();

    public void after();

    public Object around();

    public void afterReturning();

    public void afterThrowing();

    public boolean useAround();
}
