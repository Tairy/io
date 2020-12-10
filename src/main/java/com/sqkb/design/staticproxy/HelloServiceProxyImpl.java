package com.sqkb.design.staticproxy;

/**
 * package: com.sqkb.design.staticproxy
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/12/10 上午10:04
 */
public class HelloServiceProxyImpl implements HelloService {
    private HelloService target = null;

    public HelloServiceProxyImpl(HelloService target) {
        this.target = target;
    }

    @Override
    public void say(String word) {
        System.out.println("before say ...");
        target.say(word);
        System.out.println("after say ...");
    }
}