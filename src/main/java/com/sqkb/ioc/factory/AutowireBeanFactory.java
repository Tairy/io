package com.sqkb.ioc.factory;

import com.sqkb.ioc.PropertyValue;

import java.lang.reflect.Field;

/**
 * package: com.sqkb.ioc.factory
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/12/11 下午8:56
 */
public class AutowireBeanFactory extends AbstractBeanFactory {

    @Override
    Object doCreate(BeanDefinition beanDefinition) throws Exception {
        Object bean = beanDefinition.getBeanClass().newInstance();
        addPropertyValue(bean, beanDefinition);
        return bean;
    }

    protected void addPropertyValue(Object bean, BeanDefinition beanDefinition) throws Exception {
        for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValueList()) {
            Field declareField = bean.getClass().getDeclaredField(propertyValue.getName());
            declareField.setAccessible(true);
            Object value = propertyValue.getValue();
            declareField.set(bean, value);
        }
    }
}