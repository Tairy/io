package com.sqkb.aop;

import java.util.Objects;

/**
 * package: com.sqkb.aop
 *
 * @author <fangzhang> fangzhang@ibantang.com
 * @date 2020-12-10 09:09
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String word) {
        if (Objects.isNull(word) || word.trim().length() == 0) {
            System.out.println("word is invalid.");
            return;
        }

        System.out.println("Hello " + word);
    }
}
