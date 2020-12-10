package com.sqkb.design.proxy;

import com.sqkb.design.proxy.dynmicproxy.DynamicProxyFactory;
import com.sqkb.design.proxy.staticproxy.HelloServiceStaticProxyImpl;

/**
 * package: com.sqkb.design.proxy.staticproxy
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/12/10 上午10:06
 */
public class Main {

    public static void main(String[] args) {
        testStaticProxy();
        testDynamicProxy();
    }

    public static void testStaticProxy() {
        HelloService target = new HelloServiceImpl();
        HelloService proxy = new HelloServiceStaticProxyImpl(target);
        proxy.say("Bob");
    }

    public static void testDynamicProxy() {
        HelloService target = new HelloServiceImpl();
        DynamicProxyFactory dynamicProxyFactory = new DynamicProxyFactory(target);
        HelloService proxyInstance = (HelloService) dynamicProxyFactory.getProxyInstance();
        proxyInstance.say("Tom");
    }
}