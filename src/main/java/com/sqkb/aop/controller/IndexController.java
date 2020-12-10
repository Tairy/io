package com.sqkb.aop.controller;

import com.sqkb.aop.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * package: com.sqkb.aop.controller
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/12/10 下午5:10
 */
@RestController
public class IndexController {

    @Resource
    UserService userService;

    @GetMapping("/")
    public String index() {
        userService.say("world.");
        return "success";
    }
}