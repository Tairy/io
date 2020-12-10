package com.sqkb.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * package: com.sqkb.aop
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/12/10 上午9:39
 */
public class ProxyBean implements InvocationHandler {

    private Object target = null;

    private Interceptor interceptor = null;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        boolean exceptionFlag = false;
        Invocation invocation = new Invocation(target, method, args);
        Object retObj = null;
        try {
            if (this.interceptor.before()) {
                retObj = this.interceptor.around(invocation);
            } else {
                retObj = method.invoke(target, args);
            }
        } catch (Exception e) {
            exceptionFlag = true;
        }
        this.interceptor.after();
        if (exceptionFlag) {
            this.interceptor.afterThrowing();
        } else {
            this.interceptor.afterReturning();
            return retObj;
        }

        return null;
    }

    public static Object getProxyBean(Object target, Interceptor interceptor) {
        ProxyBean proxyBean = new ProxyBean();
        proxyBean.target = target;
        proxyBean.interceptor = interceptor;

        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), proxyBean);
    }
}