package com.sqkb.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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

    @Pointcut("execution(* com.sqkb.aop.service.impl.*.*(..))")
    public void pointCut() {
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("around before ...");
        jp.proceed();
        System.out.println("around after ...");
    }

    @Before("pointCut()")
    public void before() {
        System.out.println("before ....");
    }
}