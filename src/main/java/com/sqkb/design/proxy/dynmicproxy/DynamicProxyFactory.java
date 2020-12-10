package com.sqkb.design.proxy.dynmicproxy;

import java.lang.reflect.Proxy;

/**
 * package: com.sqkb.design.proxy.dynmicproxy
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/12/10 上午10:29
 */
public class DynamicProxyFactory {

    // 被代理对象
    private Object target;

    public DynamicProxyFactory(Object target) {
        this.target = target;
    }

    // 为被目标对象 target 生成代理对象 proxyInstance
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), (proxy, method, args) -> {
            System.out.println("before...");
            method.invoke(target, args);
            System.out.println("after...");
            return null;
        });
    }
}