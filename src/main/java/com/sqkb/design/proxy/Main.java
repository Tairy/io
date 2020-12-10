package com.sqkb.design.proxy;

import com.sqkb.design.proxy.dynmicproxy.ReflectDynamicProxyFactory;
import com.sqkb.design.proxy.dynmicproxy.asm.AsmProxyFactory;
import com.sqkb.design.proxy.staticproxy.HelloServiceStaticProxyImpl;

import java.lang.reflect.Constructor;

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
        testAsmDynamicProxy();
    }

    public static void testStaticProxy() {
        HelloService target = new HelloServiceImpl();
        HelloService proxy = new HelloServiceStaticProxyImpl(target);
        proxy.say("Bob");
    }

    public static void testDynamicProxy() {
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        HelloService target = new HelloServiceImpl();
        ReflectDynamicProxyFactory reflectDynamicProxyFactory = new ReflectDynamicProxyFactory(target);
        HelloService proxyInstance = (HelloService) reflectDynamicProxyFactory.getProxyInstance();
        proxyInstance.say("Tom");
    }

    public static void testAsmDynamicProxy() {
        HelloServiceImpl target = new HelloServiceImpl();
        try {
            Class clazz = HelloServiceImpl.class;
            Constructor constructor = clazz.getConstructor(new Class[]{});
            Object[] constructorParam = new Object[]{};
            HelloService proxyInstance = (HelloService) AsmProxyFactory.newProxyInstance(
                    clazz.getClassLoader(), (proxy, method, args) -> {
                        System.out.println("before..." + method.getName());
                        method.invoke(target, args);
                        System.out.println("after..." + method.getName());
                        return null;
                    }, clazz, constructor, constructorParam);
            proxyInstance.say("Tim");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}