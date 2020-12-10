package com.sqkb.aop;

import static com.sqkb.aop.ProxyBean.getProxyBean;

/**
 * package: com.sqkb.aop
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/12/10 上午9:32
 */
public class Main {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        HelloService proxy = (HelloService) getProxyBean(helloService, new CustomInterceptor());
        proxy.sayHello("zhang");
    }
}