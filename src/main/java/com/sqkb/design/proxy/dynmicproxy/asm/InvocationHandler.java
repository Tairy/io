package com.sqkb.design.proxy.dynmicproxy.asm;

import java.lang.reflect.Method;

/**
 * package: com.sqkb.design.proxy.dynmicproxy.asm
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/12/10 上午11:00
 */
public interface InvocationHandler {
    Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}