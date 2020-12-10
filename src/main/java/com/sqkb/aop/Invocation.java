package com.sqkb.aop;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * package: com.sqkb.aop
 *
 * @author <fangzhang> fangzhang@ibantang.com
 * @date 2020-12-10 09:15
 */
public class Invocation {

    private Object[] params;

    private Method method;

    private Object target;

    public Invocation(Object target, Method method, Object[] params) {
        this.target = target;
        this.method = method;
        this.params = params;
    }

    public Object processed() throws InvocationTargetException, IllegalAccessException {
        return method.invoke(target, params);
    }
}
