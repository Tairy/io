package com.sqkb.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

/**
 * package: com.sqkb.aop.aspect
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/12/10 下午5:10
 */
@Aspect
@Configuration
public class UserAspect {

    @Before("execution(* com.sqkb.aop.service.impl.*.*(..))")
    public void before() {
        System.out.println("before ....");
    }
}