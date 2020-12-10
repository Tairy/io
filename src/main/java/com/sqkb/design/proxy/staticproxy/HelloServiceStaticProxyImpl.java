package com.sqkb.design.proxy.staticproxy;

import com.sqkb.design.proxy.HelloService;

/**
 * package: com.sqkb.design.proxy.staticproxy
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/12/10 上午10:04
 */
public class HelloServiceStaticProxyImpl implements HelloService {
    private HelloService target = null;

    public HelloServiceStaticProxyImpl(HelloService target) {
        this.target = target;
    }

    @Override
    public void say(String word) {
        System.out.println("before say ...");
        target.say(word);
        System.out.println("after say ...");
    }
}