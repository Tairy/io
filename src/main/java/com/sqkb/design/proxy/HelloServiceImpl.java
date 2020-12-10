package com.sqkb.design.proxy;

import com.sqkb.design.proxy.HelloService;

/**
 * package: com.sqkb.design.proxy.staticproxy
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/12/10 上午10:03
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void say(String word) {
        System.out.println("Hello " + word);
    }
}