package com.sqkb.aop.service.impl;

import com.sqkb.aop.service.UserService;
import org.springframework.stereotype.Service;

/**
 * package: com.sqkb.aop.service.impl
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/12/10 下午5:08
 */
@Service("UserService")
public class UserServiceImpl implements UserService {
    @Override
    public void say(String word) {
        System.out.println("Hello " + word);
    }
}