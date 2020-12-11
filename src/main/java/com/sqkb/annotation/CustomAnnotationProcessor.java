package com.sqkb.annotation;

import java.lang.reflect.Method;

/**
 * package: com.sqkb.annotation
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/12/11 下午3:40
 */
public class CustomAnnotationProcessor {
    public void parseMethod(final Class<?> clazz) throws Exception {
        final Object obj = clazz.getConstructor(new Class[]{}).newInstance(new Object[]{});
        final Method[] methods = clazz.getDeclaredMethods();
        for (final Method method : methods) {
            final CustomAnnotation customAnnotation = method.getAnnotation(CustomAnnotation.class);
            if (null != customAnnotation) {
                method.invoke(obj, customAnnotation.name());
            }
        }
    }
}