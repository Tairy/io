package com.sqkb.design.staticproxy;

/**
 * package: com.sqkb.design.staticproxy
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/12/10 上午10:06
 */
public class Main {

    public static void main(String[] args) {
        HelloService target = new HelloServiceImpl();
        HelloService proxy = new HelloServiceProxyImpl(target);
        proxy.say("Bob");
    }
}